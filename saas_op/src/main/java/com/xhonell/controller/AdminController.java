package com.xhonell.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.commons.WebUtils;
import com.xhonell.pojo.dto.*;
import com.xhonell.pojo.entity.Admin;
import com.xhonell.result.Result;
import com.xhonell.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * program: saas
 * ClassName AdminController
 * description:
 * author: xhonell
 * create: 2025年01月21日21时56分
 * Version 1.0
 **/
@Controller
@RequestMapping("/admin")
@ResponseBody
@Api("用户相关的接口文档")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 返回租户列表
     * @param adminQueryDto
     * @return
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result list(AdminQueryDto adminQueryDto) {

        //创建分页条件
        Page<Admin> adminPage = new Page<>(adminQueryDto.getPage(), adminQueryDto.getLimit());

        //准备查询条件
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(adminQueryDto.getName()), Admin::getName, adminQueryDto.getName())
                .eq(!StringUtils.isEmpty(adminQueryDto.getPhone()), Admin::getPhone, adminQueryDto.getPhone())
                .gt(adminQueryDto.getStartTime() !=null, Admin::getCreated, adminQueryDto.getStartTime());

        Page<Admin> page = adminService.page(adminPage, queryWrapper);


        return Result.success(page.getTotal(), page.getRecords());
    }

    @ApiOperation(value = "添加用户的接口文档")
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Result insert(@RequestBody @Validated AdminAddDto adminAddDto, BindingResult bindingResult) {
        //校验判断
        if(bindingResult.hasErrors()){
            return WebUtils.getResult(bindingResult);
        }
        boolean save = adminService.insertAdmin(adminAddDto);
        return Result.judge(save);
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Result update(@RequestBody Admin admin) {
        boolean save = adminService.updateById(admin);
        return Result.judge(save);
    }



    @RequestMapping(value = "/find" ,method = RequestMethod.GET)
    public Result findById(@RequestParam Long id) {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Result delete(@RequestParam Long id) {
        boolean remove = adminService.removeById(id);
        return Result.judge(remove);
    }

    @RequestMapping(value = "/batchRemove" ,method = RequestMethod.POST)
    public Result batchRemove(@RequestBody BatchRemoveDto batchRemoveDto) {
        boolean remove = adminService.removeByIds(batchRemoveDto.getIds());
        return Result.judge(remove);
    }

    @RequestMapping(value="findAll" ,method = RequestMethod.GET)
    public Result findAll() {
        List<Admin> list = adminService.list();
        return Result.success(list);
    }


    @ApiOperation("登录接口的文档")
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public Result login(@RequestBody AdminLoginDto adminLoginDto) {
        String token = adminService.login(adminLoginDto);
        return Result.success(token);
    }

}
