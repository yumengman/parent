package com.ymm.goods.modules.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymm.goods.modules.goods.dao.PhInfoDao;
import com.ymm.goods.modules.goods.entity.PhInfoEntity;
import com.ymm.goods.modules.goods.service.PhInfoService;
import org.springframework.stereotype.Service;


@Service("phInfoService")
public class PhInfoServiceImpl extends ServiceImpl<PhInfoDao, PhInfoEntity> implements PhInfoService {

}
