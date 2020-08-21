package com.ymm.goods.modules.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymm.goods.modules.goods.dao.GoodsDao;
import com.ymm.goods.modules.goods.entity.GoodsEntity;
import com.ymm.goods.modules.goods.service.GoodsService;
import org.springframework.stereotype.Service;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {



}
