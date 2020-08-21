package com.ymm.gateway.filter;


import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

/**
 * @Description
 * @Date 2020-08-11 14:12
 * @Author ymm
 **/
@Slf4j
@Component
@Configuration
public class RequestGlobalFilter implements GlobalFilter, Ordered {
  /**授权访问用户名*/
  @Value("${spring.security.user.name}")
  private String securityUserName;
  /**授权访问密码*/
  @Value("${spring.security.user.password}")
  private String securityUserPassword;

  private final static String POST = "POST";
  private final static String PUT = "PUT";
  private final static String GET = "GET";
  private final static String DELETE = "DELETE";

  /**
   * @description    执行逻辑
   * @date 2020-08-11 16:17
   * @param exchange
   * @param chain
   * @author ymm
   * @return reactor.core.publisher.Mono<java.lang.Void>
   */
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    String auth= securityUserName.concat(":").concat(securityUserPassword);
    String encodedAuth = new sun.misc.BASE64Encoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
    //注意Basic后面有空格
    String authHeader= "Basic " +encodedAuth;
    //向headers中放授权信息
    ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().header("Authorization",authHeader).build();
    //将现在的request变成change对象
    ServerWebExchange build =exchange.mutate().request(serverHttpRequest).build();

    Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
    URI routeUri = route.getUri();


    String uri = build.getRequest().getURI().toString();
    //打印每次请求的url
    log.info(" uri : " + uri);
    return chain.filter(build);
  }
  /**
   * 从Flux<DataBuffer>中获取字符串的方法
   * @return 请求体
   */
  private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
    //获取请求体
    Flux<DataBuffer> body = serverHttpRequest.getBody();

    AtomicReference<String> bodyRef = new AtomicReference<>();
    body.subscribe(buffer -> {
      CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
      DataBufferUtils.release(buffer);
      bodyRef.set(charBuffer.toString());
    });
    //获取request body
    return bodyRef.get();
  }

  private DataBuffer stringBuffer(String value) {
    byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

    NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
    DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
    buffer.write(bytes);
    return buffer;
  }

  /**
   * @description        执行顺序
   * @date 2020-08-11 14:17
   */
  @Override
  public int getOrder() {
    return 11;
  }
}