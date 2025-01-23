package com.xhonell.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.pojo.dto.BatchRemoveDto;
import com.xhonell.pojo.dto.RoleQueryDto;
import com.xhonell.pojo.dto.UpdateRolePermissionDto;
import com.xhonell.pojo.entity.Role;
import com.xhonell.pojo.vo.RoleListVo;
import com.xhonell.result.Result;
import com.xhonell.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * program: saas
 * ClassName RoleController
 * description:
 * author: xhonell
 * create: 2025年01月18日21时56分
 * Version 1.0
 **/
@Controller
@RequestMapping("/role")
@ResponseBody
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 返回租户列表
     * @param roleQueryDto
     * @return
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result list(RoleQueryDto roleQueryDto){
        Page<RoleListVo> listVoPage = roleService.findRoleByQueryDto(roleQueryDto);
        return Result.success(listVoPage.getTotal(), listVoPage.getRecords());
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Result insert(@RequestBody Role role) {
        boolean save = roleService.save(role);
        return Result.judge(save);
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Result update(@RequestBody Role role) {
        boolean save = roleService.updateById(role);
        return Result.judge(save);
    }



    @RequestMapping(value = "/find" ,method = RequestMethod.GET)
    public Result findById(@RequestParam Long id) {
        Role role = roleService.getById(id);
        return Result.success(role);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Result delete(@RequestParam Long id) {
        boolean remove = roleService.removeById(id);
        return Result.judge(remove);
    }

    @RequestMapping(value = "/batchRemove" ,method = RequestMethod.POST)
    public Result batchRemove(@RequestBody BatchRemoveDto batchRemoveDto) {
        boolean remove = roleService.removeByIds(batchRemoveDto.getIds());
        return Result.judge(remove);
    }

    @RequestMapping(value="findAll" ,method = RequestMethod.GET)
    public Result findAll() {
        List<Role> list = roleService.list();
        return Result.success(list);
    }

    @RequestMapping(value = "/updateRolePermission",method = RequestMethod.POST)
    public Result updateRolePermission(@RequestBody UpdateRolePermissionDto updateRolePermissionDto){
        roleService.updateRolePermission(updateRolePermissionDto);
        return Result.success();
    }


    @RequestMapping(value = "/findRoleByAdminId",method = RequestMethod.GET)
    public Result findRoleByAdminId(@RequestParam Long adminId){
        List<Long> list = roleService.findRoleIdsByAdminId(adminId);
        return Result.success(list);
    }
}
