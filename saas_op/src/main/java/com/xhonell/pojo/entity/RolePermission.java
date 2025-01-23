package com.xhonell.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * program: saas
 * ClassName RolePermission
 * description:
 * author: xhonell
 * create: 2025年01月23日22时29分
 * Version 1.0
 **/
@Data
@TableName("op_role_permission")
public class RolePermission implements Serializable {

    private Long roleId;

    private Long permissionId;
}
