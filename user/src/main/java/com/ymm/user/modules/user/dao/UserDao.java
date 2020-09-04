package com.ymm.user.modules.user.dao;

import com.ymm.user.modules.user.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表
 * 
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-21 17:00:59
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
