package com.ymm.user.modules.user.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ymm.user.modules.user.dao.UserDao;
import com.ymm.user.modules.user.entity.UserEntity;
import com.ymm.user.modules.user.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

}
