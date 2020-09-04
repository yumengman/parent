
package com.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *分页总配置类
 * @author ymm
 */
@Data
@ApiModel("分页数据信息")
public class PageUtils<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *	总条数
	 */
	@ApiModelProperty("总条数")
	private long totalCount;
	/**
	 *	每页条数
	 */
	@ApiModelProperty("每页条数")
	private int pageSize;
	/**
	 *	总页数
	 */
	@ApiModelProperty("总页数")
	private int totalPage;
	/**
	 *	当前页
	 */
	@ApiModelProperty("当前页")
	private int currPage;
	/**
	 *	结果信息
	 */
	@ApiModelProperty("结果信息")
	private List<T> list;
	
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtils(List<T> list, long totalCount, int pageSize, int currPage) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}
}
