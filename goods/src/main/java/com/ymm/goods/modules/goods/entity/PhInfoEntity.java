package com.ymm.goods.modules.goods.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-16 16:26:21
 */
@Data
@TableName("ph_info")
@ApiModel(value= "com.ymm.goods.modules.goods.entity.PhInfoEntity")
public class PhInfoEntity implements Serializable {
	private static final long serialVersionUID = -8244640393749138288L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="")
	private Long goodsId;
		/**
	 * 
	 */
	@TableField(value = "ph_name")
	@ApiModelProperty(value="")
	private String phName;
	/**
	 * 
	 */
	@TableField(value = "ph_weight")
	@ApiModelProperty(value="")
	private String phWeight;
	/**
	 * 
	 */
	@TableField(value = "ph_cpu")
	@ApiModelProperty(value="")
	private String phCpu;
	/**
	 * 
	 */
	@TableField(value = "ph_ram")
	@ApiModelProperty(value="")
	private String phRam;
	/**
	 * 
	 */
	@TableField(value = "ph_rom")
	@ApiModelProperty(value="")
	private String phRom;
	/**
	 * 
	 */
	@TableField(value = "ph_microSD")
	@ApiModelProperty(value="")
	private String phMicrosd;
	/**
	 * 
	 */
	@TableField(value = "ph_camera")
	@ApiModelProperty(value="")
	private String phCamera;
	/**
	 * 
	 */
	@TableField(value = "ph_camera_front")
	@ApiModelProperty(value="")
	private String phCameraFront;
	/**
	 * 
	 */
	@TableField(value = "ph_camera_back")
	@ApiModelProperty(value="")
	private String phCameraBack;
	/**
	 * 
	 */
	@TableField(value = "ph_screen")
	@ApiModelProperty(value="")
	private String phScreen;
	/**
	 * 
	 */
	@TableField(value = "ph_resolution")
	@ApiModelProperty(value="")
	private String phResolution;
	/**
	 * 
	 */
	@TableField(value = "ph_scree_type")
	@ApiModelProperty(value="")
	private String phScreeType;
	/**
	 * 
	 */
	@TableField(value = "ph_share")
	@ApiModelProperty(value="")
	private String phShare;
	/**
	 * 库存
	 */
	@TableField(value = "ph_battery")
	@ApiModelProperty(value="库存")
	private Integer phBattery;
	/**
	 * 
	 */
	@TableField(value = "ph_charger")
	@ApiModelProperty(value="")
	private String phCharger;
	/**
	 * 
	 */
	@TableField(value = "ph_system")
	@ApiModelProperty(value="")
	private String phSystem;
	/**
	 * 
	 */
	@TableField(value = "commodity_pic")
	@ApiModelProperty(value="")
	private String commodityPic;

}
