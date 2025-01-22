package com.xhonell.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * program: saas
 * ClassName AdminAddDto
 * description:
 * author: xhonell
 * create: 2025年01月21日19时40分
 * Version 1.0
 **/
@Data
@ApiModel("管理员的添加")
public class AdminAddDto implements Serializable {
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty("姓名")
    private String name;

    @Pattern(regexp = "^\\\\w{5,20}$" ,message = "用户名不合法")
    @ApiModelProperty("用户名")
    private String username;

    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\\\d{8}$" ,message = "手机号不合法")
    @ApiModelProperty("手机号")
    private String phone;

    @Email(message = "邮箱格式不合法!")
    @ApiModelProperty("邮箱")
    private String email;

    @NotBlank(message = "头像不能为空!")
    @ApiModelProperty("图片地址")
    private String image;
}
