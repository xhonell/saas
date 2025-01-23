package com.xhonell.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhonell.pojo.dto.RoleQueryDto;
import com.xhonell.pojo.dto.UpdateRolePermissionDto;
import com.xhonell.pojo.entity.Role;
import com.xhonell.pojo.vo.RoleListVo;

import java.util.List;

/**
 * program: saas
 * ClassName RoleService
 * description:
 * author: xhonell
 * create: 2025年01月23日21时06分
 * Version 1.0
 **/
public interface RoleService extends IService<Role> {

    /**
     * 分页查询角色列表
     * @param roleQueryDto
     * @return
     */
    Page<RoleListVo> findRoleByQueryDto(RoleQueryDto roleQueryDto);

    /**
     * 修改角色权限
     * @param updateRolePermission
     */
    void updateRolePermission(UpdateRolePermissionDto updateRolePermission);

    List<Long> findRoleIdsByAdminId(Long adminId);
}
