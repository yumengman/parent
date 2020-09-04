package com.ymm.user.modules.user.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 用户信息表
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-21 17:00:59
 */
@Data
public class UserParam {


	/**
	 * 姓名
	 */
	@ApiModelProperty(value="姓名")
	private String userName;
	/**
	 * 手机号
	 */
	@ApiModelProperty(value="手机号")
	private String mobile;
	/**
	 * 密码
	 */
	@ApiModelProperty(value="密码")
	private String password;
	/**
	 * 微信唯一标识
	 */
	@ApiModelProperty(value="微信唯一标识")
	private String openId;
	/**
	 * 支付宝标识Id
	 */
	@ApiModelProperty(value="支付宝标识Id")
	private String aliId;
	/**
	 * 积分
	 */
	@ApiModelProperty(value="积分")
	private Integer integral;
}
