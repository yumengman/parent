package com.ymm.goods.modules.goods.controller;

import com.ymm.goods.modules.goods.entity.PhInfoEntity;
import com.ymm.goods.modules.goods.service.PhInfoService;
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
 * @date 2020-08-16 16:26:21
 */
@RestController
@RequestMapping("/api/ph")
@Api(tags = "商品详情")
public class PhInfoController {
    @Autowired
    private PhInfoService phInfoService;

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
        PhInfoEntity phInfo = phInfoService.getById(goodsId);

        return R.ok().put("data", phInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增保存")
    public R save(@RequestBody PhInfoEntity phInfo){
        phInfoService.save(phInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public R update(@RequestBody PhInfoEntity phInfo){
        phInfoService.updateById(phInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public R delete(@RequestBody Long[] goodsIds){
        phInfoService.removeByIds(Arrays.asList(goodsIds));

        return R.ok();
    }

}
