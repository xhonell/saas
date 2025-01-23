package com.xhonell.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhonell.mapper.AdminRoleMapper;
import com.xhonell.mapper.RoleMapper;
import com.xhonell.mapper.RolePermissionMapper;
import com.xhonell.pojo.dto.RoleQueryDto;
import com.xhonell.pojo.dto.UpdateRolePermissionDto;
import com.xhonell.pojo.entity.AdminRole;
import com.xhonell.pojo.entity.Role;
import com.xhonell.pojo.entity.RolePermission;
import com.xhonell.pojo.vo.RoleListVo;
import com.xhonell.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * program: saas
 * ClassName RoleServiceImpl
 * description:
 * author: xhonell
 * create: 2025年01月23日21时07分
 * Version 1.0
 **/
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;


    @Override
    public Page<RoleListVo> findRoleByQueryDto(RoleQueryDto roleQueryDto) {
        Page<Role> page=new Page<>(roleQueryDto.getPage(),roleQueryDto.getLimit());
        return getBaseMapper().findRoleByQueryDto(page,roleQueryDto);
    }

    @Override
    public void updateRolePermission(UpdateRolePermissionDto updateRolePermission) {

        //1.删除角色对应的权限
        LambdaQueryWrapper<RolePermission> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RolePermission::getRoleId,updateRolePermission.getRoleId());
        rolePermissionMapper.delete(lambdaQueryWrapper);

        //2.获取权限id的集合
        List<Long> permissionIds = updateRolePermission.getPermissionIds();

        //3.判断权限id集合不为空
        if(!CollectionUtils.isEmpty(permissionIds)){

            log.debug("往中间表插入数据...roleId:{},permissionIds:{}",updateRolePermission.getRoleId(),permissionIds);

            permissionIds.forEach(permissionId->{
                RolePermission rolePermission=new RolePermission();
                rolePermission.setRoleId(updateRolePermission.getRoleId());
                rolePermission.setPermissionId(permissionId);
                rolePermissionMapper.insert(rolePermission);
            });

        }

    }

    @Override
    public List<Long> findRoleIdsByAdminId(Long adminId) {

        LambdaQueryWrapper<AdminRole> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(AdminRole::getAdminId,adminId);
        List<AdminRole> roleIds = adminRoleMapper.selectList(lambdaQueryWrapper);

        return roleIds.stream().map(AdminRole::getRoleId)
                .collect(Collectors.toList());
    }
}
