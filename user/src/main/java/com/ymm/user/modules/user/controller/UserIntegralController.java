package com.ymm.user.modules.user.controller;

import com.common.enums.ResultResponseEnum;
import com.common.utils.PageUtils;
import com.common.utils.ResultResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ymm.user.modules.user.entity.UserIntegralEntity;
import com.ymm.user.modules.user.service.UserIntegralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;



/**
 * 用户积分表
 *
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-21 17:00:59
 */
@RestController
@RequestMapping("/api/userIntegral")
@Api(tags = "用户积分表")
public class UserIntegralController {
    @Autowired
    private UserIntegralService userIntegralService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "用户积分表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNo", value = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "10")
    })
    public PageUtils<Object> list(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        PageHelper.startPage(pageNo,pageSize,true);
        PageInfo pageInfo = new PageInfo(userIntegralService.list());
        return new PageUtils(pageInfo.getList(),pageInfo.getTotal(),pageSize,pageNo);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "用户积分表信息")
    public UserIntegralEntity info(@PathVariable("id") Long id){
        UserIntegralEntity userIntegral = userIntegralService.getById(id);

        return userIntegral;
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "用户积分表新增保存")
    public ResultResponse save(@RequestBody UserIntegralEntity userIntegral){
        userIntegralService.save(userIntegral);

        return new ResultResponse(ResultResponseEnum.SUCCESS.getCode(),null);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "用户积分表修改")
    public ResultResponse update(@RequestBody UserIntegralEntity userIntegral){
        userIntegralService.updateById(userIntegral);

        return new ResultResponse(ResultResponseEnum.SUCCESS.getCode(),null);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "用户积分表删除")
    public ResultResponse delete(@RequestBody Long[] ids){
        userIntegralService.removeByIds(Arrays.asList(ids));

        return new ResultResponse(ResultResponseEnum.SUCCESS.getCode(),null);
    }

}
