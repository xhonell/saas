package com.xhonell.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * program: saas
 * ClassName AdminLoginDto
 * description:
 * author: xhonell
 * create: 2025年01月21日20时20分
 * Version 1.0
 **/
@ApiModel("登录参数")
@Data
public class AdminLoginDto implements Serializable {
    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
