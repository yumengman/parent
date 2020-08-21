package com.ymm.goods.modules.goods.controller;

import com.ymm.goods.modules.goods.entity.GoodsEntity;
import com.ymm.goods.modules.goods.service.GoodsService;
import com.ymm.goods.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-16 16:26:20
 */
@RestController
@RequestMapping("/api/goods")
@Api(tags = "商品管理")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public R list(@RequestParam Map<String, Object> params){
        return R.ok();
    }


    /**
     * 信息
     */
    @GetMapping("/info/{goodsId}")
    @ApiOperation(value = "信息")
    public R info(@PathVariable("goodsId") Long goodsId){
        GoodsEntity goods = goodsService.getById(goodsId);

        return R.ok().put("data", goods);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增保存")
    public R save(@RequestBody GoodsEntity goods){
        goodsService.save(goods);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public R update(@RequestBody GoodsEntity goods){
        goodsService.updateById(goods);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public R delete(@RequestBody Long[] goodsIds){
        goodsService.removeByIds(Arrays.asList(goodsIds));

        return R.ok();
    }

    public static void main(String[] args) {

    }

}
