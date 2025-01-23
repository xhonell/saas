package com.xhonell.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * program: saas
 * ClassName AdminRole
 * description:
 * author: xhonell
 * create: 2025年01月23日23时20分
 * Version 1.0
 **/
@Data
@TableName("op_admin_role")
public class AdminRole implements Serializable {
    private Long adminId;
    private Long roleId;
}
