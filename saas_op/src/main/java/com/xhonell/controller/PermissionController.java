package com.xhonell.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.pojo.dto.BatchRemoveDto;
import com.xhonell.pojo.dto.PermissionQueryDto;
import com.xhonell.pojo.entity.Permission;
import com.xhonell.result.Result;
import com.xhonell.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * program: saas
 * ClassName PermissionController
 * description:
 * author: xhonell
 * create: 2025年01月18日21时56分
 * Version 1.0
 **/
@Controller
@RequestMapping("/permission")
@ResponseBody
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 返回租户列表
     * @param permissionQueryDto
     * @return
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result list(PermissionQueryDto permissionQueryDto) {

        //创建分页条件
        Page<Permission> permissionPage = new Page<>(permissionQueryDto.getPage(), permissionQueryDto.getLimit());

        //准备查询条件
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(permissionQueryDto.getName()), Permission::getName, permissionQueryDto.getName());


        Page<Permission> page = permissionService.page(permissionPage, queryWrapper);


        return Result.success(page.getTotal(), page.getRecords());
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Result insert(@RequestBody Permission permission) {
        boolean save = permissionService.save(permission);
        return Result.judge(save);
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Result update(@RequestBody Permission permission) {
        boolean save = permissionService.updateById(permission);
        return Result.judge(save);
    }



    @RequestMapping(value = "/find" ,method = RequestMethod.GET)
    public Result findById(@RequestParam Long id) {
        Permission permission = permissionService.getById(id);
        return Result.success(permission);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Result delete(@RequestParam Long id) {
        boolean remove = permissionService.removeById(id);
        return Result.judge(remove);
    }

    @RequestMapping(value = "/batchRemove" ,method = RequestMethod.POST)
    public Result batchRemove(@RequestBody BatchRemoveDto batchRemoveDto) {
        boolean remove = permissionService.removeByIds(batchRemoveDto.getIds());
        return Result.judge(remove);
    }

    @RequestMapping(value="findAll" ,method = RequestMethod.GET)
    public Result findAll() {
        List<Permission> list = permissionService.list();
        return Result.success(list);
    }

    @RequestMapping(value = "/findPermissionByRoleId",method = RequestMethod.GET)
    public Result findPermissionByRoleId(@RequestParam Long roleId){
        List<Long> list = permissionService.findPermissionIdsByRoleId(roleId);
        return Result.success(list);
    }

}
