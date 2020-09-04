package com.ymm.user.respone;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.common.enums.ResultResponseEnum;
import com.common.exception.BusinessException;
import com.common.utils.PageUtils;
import com.common.utils.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Enumeration;


/**
 *  统一响应体处理器
 * @author ymm
 * @date 2020-08-21 16:45
 * @return
**/
@Slf4j
@RestControllerAdvice(basePackages = "com.ymm.user.modules")
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(
            @Nullable Object body,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse
    ) {
        // 对返回值body进行封装处理
        ResultResponse resultResponse;
        if (body == null) {
            resultResponse = new ResultResponse(ResultResponseEnum.NO_DATA, null);
        } else if (body instanceof ResultResponse) {
            // 由处理异常后抛出的返回值直接返回即可
            resultResponse = (ResultResponse) body;
        } else if (body instanceof Boolean) {
            // 返回值是布尔类型 根据布尔值返回响应码
            if ((Boolean) body) {
                resultResponse = new ResultResponse(ResultResponseEnum.SUCCESS, body);
            } else {
                resultResponse = new ResultResponse(ResultResponseEnum.OPERATION_FAILED, body);
            }
        } else if (body instanceof Collection) {
            Collection collection = (Collection) body;
            if (collection == null) {
                resultResponse = new ResultResponse(ResultResponseEnum.SUCCESS, collection);
            } else {
                resultResponse = new ResultResponse(ResultResponseEnum.NO_DATA,  null);
            }
        } else if (body instanceof PageUtils) {
            // 返回值是page 根据records是否是empty返回响应码
            PageUtils pageVO = (PageUtils) body;
            if (CollectionUtils.isNotEmpty(pageVO.getList())) {
                resultResponse = new ResultResponse(ResultResponseEnum.SUCCESS,  pageVO);
            } else {
                resultResponse = new ResultResponse(ResultResponseEnum.NO_DATA,  null);
            }
        } else if (body instanceof ResultResponseEnum) {
            // 返回值是ResponseEnum 转换Response 返回响应码
            resultResponse = new ResultResponse((ResultResponseEnum) body,  null);
        } else if (body instanceof String) {
            // 字符串特殊处理
            return JSONObject.toJSONString(new ResultResponse(ResultResponseEnum.SUCCESS, body));
        } else {
            resultResponse = new ResultResponse(ResultResponseEnum.SUCCESS, body);
        }

        if (!resultResponse.getCode().equals(ResultResponseEnum.SUCCESS.getCode())) {
            //返回结果非1000  打印异常信息
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

            log.error("response is not ok;the headers is {}, pathUrl is {},method is {},contentType is {},queryString is {},resultResponse.code is {}, body is {}",
                    getHeaders(request),
                    request.getLocalAddr() + request.getServletPath(),
                    request.getMethod(),
                    request.getContentType(),
                    request.getQueryString(),
                    resultResponse.getCode(),
                    JSONObject.toJSONString(body)
            );
        }

        return resultResponse;
    }

    /**
     * 处理自定义异常
     *
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultResponse handleBusinessException(HttpServletRequest request, BusinessException e) {
        log.error("[handleBusinessException]: the headers is {}, pathUrl is {},method is {},contentType is {},queryString is {}, message is {},e is {}",
                getHeaders(request),
                request.getLocalAddr() + request.getServletPath(),
                request.getMethod(),
                request.getContentType(),
                request.getQueryString(),
                e.getResultResponse().getDataMsg(),
                e
        );
        return e.getResultResponse();
    }

    /**
     * 处理未捕获的Exception
     *
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultResponse handleException(HttpServletRequest request, Exception e) {
        log.error("[handleException]: the headers is {}, pathUrl is {},method is {},contentType is {},queryString is {},the message is {}",
                getHeaders(request),
                request.getLocalAddr() + request.getServletPath(),
                request.getMethod(),
                request.getContentType(),
                request.getQueryString(),
                e
        );
        return new ResultResponse(ResultResponseEnum.SYSTEM_ERROR, null);
    }


    /**
     * 处理请求参数缺失异常MissingServletRequestParameterException
     *
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultResponse handleMissingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException e) {
        log.error("[handleMissingServletRequestParameterException]: the headers is {}, pathUrl is {},method is {},contentType is {},queryString is {},the message is {}",
                getHeaders(request),
                request.getLocalAddr() + request.getServletPath(),
                request.getMethod(),
                request.getContentType(),
                request.getQueryString(),
                e
        );
        return new ResultResponse(ResultResponseEnum.REQUIRED_PARAMETERS_ARE_MISSING,  null);
    }


    /**
     * 处理方法验证参数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultResponse methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {

        log.error("[methodArgumentNotValidExceptionHandler]: the headers is {}, pathUrl is {},method is {},contentType is {},queryString is {},the message is {}",
                getHeaders(request),
                request.getLocalAddr() + request.getServletPath(),
                request.getMethod(),
                request.getContentType(),
                request.getQueryString(),
                e
        );

        return new ResultResponse(
                ResultResponseEnum.ILLEGAL_PARA_METE, null
        );
    }

    /**
     * 请求体异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultResponse httpMessageNotReadableExceptionHandler(HttpServletRequest request, HttpMessageNotReadableException e) {

        log.error("[httpMessageNotReadableExceptionHandler]: the headers is {}, pathUrl is {},method is {},contentType is {},queryString is {},the message is {}",
                getHeaders(request),
                request.getLocalAddr() + request.getServletPath(),
                request.getMethod(),
                request.getContentType(),
                request.getQueryString(),
                e
        );

        return new ResultResponse(ResultResponseEnum.REQUEST_BODY_EXCEPTION, null);
    }


    /**
     * 获取请求头信息数据
     *
     * @param request
     * @return
     */
    private String getHeaders(HttpServletRequest request) {
        //获取所有请求头名称
        String headers = "";
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                //根据名称获取请求头的值
                String value = request.getHeader(name);
                headers += name + ":" + value + "|";
            }
        }
        return headers;
    }


}
