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
 * 用户积分表
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-21 17:00:59
 */
@Data
@TableName("t_user_integral")
@ApiModel(value= "com.ymm.user.modules.user.entity.UserIntegralEntity")
public class UserIntegralEntity implements Serializable {
	private static final long serialVersionUID = 297395135686380497L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value="ID")
	private Long id;
		/**
	 * 用户ID
	 */
	@TableField(value = "user_id")
	@ApiModelProperty(value="用户ID")
	private Long userId;
	/**
	 * 积分值
	 */
	@TableField(value = "integral")
	@ApiModelProperty(value="积分值")
	private Integer integral;
	/**
	 * 积分来源 1 登陆奖励
	 */
	@TableField(value = "source")
	@ApiModelProperty(value="积分来源 1 登陆奖励")
	private Integer source;
	/**
	 * 
	 */
	@TableField(value = "del_flag")
	@ApiModelProperty(value="")
	private Integer delFlag;
	/**
	 * 创建人
	 */
	@TableField(value = "create_user")
	@ApiModelProperty(value="创建人")
	private Long createUser;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value="创建时间")
	private Date createTime;
	/**
	 * 修改人
	 */
	@TableField(value = "update_user")
	@ApiModelProperty(value="修改人")
	private Long updateUser;
	/**
	 * 修改时间
	 */
	@TableField(value = "update_time")
	@ApiModelProperty(value="修改时间")
	private Date updateTime;

}
