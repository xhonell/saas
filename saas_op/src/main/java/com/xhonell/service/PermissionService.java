package com.xhonell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhonell.pojo.entity.Permission;

import java.util.List;

/**
 * program: saas
 * ClassName PermissionService
 * description:
 * author: xhonell
 * create: 2025年01月23日21时09分
 * Version 1.0
 **/
public interface PermissionService extends IService<Permission> {

    /**
     * 根据角色id查询权限id的集合
     * @param roleId
     * @return
     */
    List<Long> findPermissionIdsByRoleId(Long roleId);
}
