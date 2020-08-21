package com.ymm.goods.modules.goods.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-16 16:26:20
 */
@Data
@TableName("goods")
@ApiModel(value= "com.ymm.goods.modules.goods.entity.GoodsEntity")
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 8327606649371850834L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
	private Long goodsId;
		/**
	 * 
	 */
	@TableField(value = "goods__name")
	@ApiModelProperty(value="")
	private String goodsName;
	/**
	 * 
	 */
	@TableField(value = "shop_name")
	@ApiModelProperty(value="")
	private String shopName;
	/**
	 * 
	 */
	@TableField(value = "goods__price")
	@ApiModelProperty(value="")
	private BigDecimal goodsPrice;
	/**
	 * 
	 */
	@TableField(value = "goods__url")
	@ApiModelProperty(value="")
	private String goodsUrl;
	/**
	 * 商品状态 0 在架 -1 下架
	 */
	@TableField(value = "del_flag")
	@ApiModelProperty(value="商品状态 0 在架 -1 下架")
	private Integer delFlag;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value="创建时间")
	private Date createTime;
	/**
	 * 修改时间
	 */
	@TableField(value = "update_time")
	@ApiModelProperty(value="修改时间")
	private Date updateTime;

}
