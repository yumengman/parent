package com.ymm.user.modules.user.controller;

import com.common.enums.ResultResponseEnum;
import com.common.utils.PageUtils;
import com.common.utils.ResultResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ymm.user.modules.user.entity.UserEntity;
import com.ymm.user.modules.user.param.UserParam;
import com.ymm.user.modules.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;



/**
 * 用户信息表
 *
 * @author ymm
 * @email yumengman@hytongtech.com
 * @date 2020-08-21 17:00:59
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户信息表")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "用户信息表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNo", defaultValue = "1", value = "页码"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", defaultValue = "10", value = "每页条数")
    })
    public PageUtils<UserParam> list(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        PageHelper.startPage(pageNo,pageSize,true);
        PageInfo pageInfo = new PageInfo(userService.list());
        return new PageUtils(pageInfo.getList(),pageInfo.getTotal(),pageSize,pageNo);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "用户信息表信息")
    public UserEntity info(@PathVariable("id") Long id){
        UserEntity user = userService.getById(id);

        return user;
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "用户信息表新增保存")
    public ResultResponse save(@RequestBody UserParam userParam){
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userParam,user);
        userService.save(user);
        return new ResultResponse(ResultResponseEnum.SUCCESS.getCode(),null);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "用户信息表修改")
    public ResultResponse update(@RequestBody UserEntity user){
        userService.updateById(user);

        return new ResultResponse(ResultResponseEnum.SUCCESS.getCode(),null);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "用户信息表删除")
    public ResultResponse delete(@RequestBody Long[] ids){
        userService.removeByIds(Arrays.asList(ids));

        return new ResultResponse(ResultResponseEnum.SUCCESS.getCode(),null);
    }

}
