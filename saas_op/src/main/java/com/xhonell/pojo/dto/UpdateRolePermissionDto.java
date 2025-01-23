package com.xhonell.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * program: saas
 * ClassName UpdateRolePermission
 * description:
 * author: xhonell
 * create: 2025年01月23日22时28分
 * Version 1.0
 **/
@Data
public class UpdateRolePermissionDto implements Serializable {

    //角色id
    private Long roleId;

    //权限id的集合
    private List<Long> permissionIds;
}
