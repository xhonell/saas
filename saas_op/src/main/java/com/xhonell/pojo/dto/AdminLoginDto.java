package com.xhonell.pojo.dto;

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
@Data
public class AdminLoginDto implements Serializable {
    private String username;

    private String password;
}
