package com.xhonell.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * program: saas
 * ClassName RoleListVo
 * description:
 * author: xhonell
 * create: 2025年01月23日22时24分
 * Version 1.0
 **/
@Data
public class RoleListVo implements Serializable {

    private Long id;

    private String name;

    private String pname;

    private String description;
}
