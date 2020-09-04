package com.ymm.user.modules.user.dao;

import com.ymm.user.modules.user.entity.UserIntegralEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户积分表
 * 
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-21 17:00:59
 */
@Mapper
public interface UserIntegralDao extends BaseMapper<UserIntegralEntity> {
	
}
