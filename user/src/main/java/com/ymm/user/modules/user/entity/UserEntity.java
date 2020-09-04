package com.ymm.user.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户信息表
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-21 17:00:59
 */
@Data
@TableName("t_user")
@ApiModel(value= "com.ymm.user.modules.user.entity.UserEntity")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 3005838733965653837L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value="ID")
	private Long id;
		/**
	 * 姓名
	 */
	@TableField(value = "user_name")
	@ApiModelProperty(value="姓名")
	private String userName;
	/**
	 * 手机号
	 */
	@TableField(value = "mobile")
	@ApiModelProperty(value="手机号")
	private String mobile;
	/**
	 * 密码
	 */
	@TableField(value = "password")
	@ApiModelProperty(value="密码")
	private String password;
	/**
	 * 微信唯一标识
	 */
	@TableField(value = "open_id")
	@ApiModelProperty(value="微信唯一标识")
	private String openId;
	/**
	 * 支付宝标识Id
	 */
	@TableField(value = "ali_id")
	@ApiModelProperty(value="支付宝标识Id")
	private String aliId;
	/**
	 * 积分
	 */
	@TableField(value = "integral")
	@ApiModelProperty(value="积分")
	private Integer integral;
	/**
	 * 人员状态 0 正常 -1 删除
	 */
	@TableField(value = "del_flag")
	@ApiModelProperty(value="人员状态 0 正常 -1 删除")
	private Integer delFlag;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value="创建时间")
	private Date createTime;
	/**
	 * 创建人
	 */
	@TableField(value = "create_user")
	@ApiModelProperty(value="创建人")
	private Long createUser;
	/**
	 * 修改时间
	 */
	@TableField(value = "update_time")
	@ApiModelProperty(value="修改时间")
	private Date updateTime;
	/**
	 * 修改人
	 */
	@TableField(value = "update_user")
	@ApiModelProperty(value="修改人")
	private Long updateUser;

}
