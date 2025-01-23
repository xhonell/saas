package com.xhonell.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * program: saas
 * ClassName UpdateAdminRole
 * description:
 * author: xhonell
 * create: 2025年01月23日23时19分
 * Version 1.0
 **/
@Data
public class UpdateAdminRoleDto implements Serializable {

    private Long adminId;
    private List<Long> roleIds;
}
