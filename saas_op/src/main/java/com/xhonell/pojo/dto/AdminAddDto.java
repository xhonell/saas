package com.xhonell.pojo.dto;

import lombok.Data;

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
public class AdminAddDto implements Serializable {
    private String name;

    private String username;

    private String phone;

    private String email;

    private String image;
}
