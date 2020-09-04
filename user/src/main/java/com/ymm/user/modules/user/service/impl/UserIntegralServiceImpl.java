package com.ymm.user.modules.user.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ymm.user.modules.user.dao.UserIntegralDao;
import com.ymm.user.modules.user.entity.UserIntegralEntity;
import com.ymm.user.modules.user.service.UserIntegralService;


@Service("userIntegralService")
public class UserIntegralServiceImpl extends ServiceImpl<UserIntegralDao, UserIntegralEntity> implements UserIntegralService {

}
