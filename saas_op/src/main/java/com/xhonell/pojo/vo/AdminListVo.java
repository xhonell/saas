package com.xhonell.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * program: saas
 * ClassName AdminListVo
 * description:
 * author: xhonell
 * create: 2025年01月23日22时45分
 * Version 1.0
 **/
@Data
public class AdminListVo implements Serializable {
    private Long id;
    private String name;
    private String rname;
    private String phone;
    private String image;
    private String email;
}
