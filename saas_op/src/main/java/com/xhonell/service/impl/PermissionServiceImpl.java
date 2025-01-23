package com.xhonell.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhonell.mapper.PermissionMapper;
import com.xhonell.mapper.RolePermissionMapper;
import com.xhonell.pojo.entity.Permission;
import com.xhonell.pojo.entity.RolePermission;
import com.xhonell.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * program: saas
 * ClassName PermissionServiceImpl
 * description:
 * author: xhonell
 * create: 2025年01月23日21时11分
 * Version 1.0
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Long> findPermissionIdsByRoleId(Long roleId) {

        LambdaQueryWrapper<RolePermission> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RolePermission::getRoleId,roleId);
        List<RolePermission> permissionList = rolePermissionMapper.selectList(lambdaQueryWrapper);

        List<Long> permissionListIds = permissionList.stream().map(rolePermission -> rolePermission.getPermissionId())
                .collect(Collectors.toList());
        return permissionListIds;
    }
}
