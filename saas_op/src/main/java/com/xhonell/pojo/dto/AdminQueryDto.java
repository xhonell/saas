package com.xhonell.pojo.dto;

import lombok.Data;

import java.util.Date;

/**
 * program: saas
 * ClassName AdminQueryDto
 * description:
 * author: xhonell
 * create: 2025年01月21日14时17分
 * Version 1.0
 **/
@Data
public class AdminQueryDto extends BaseQueryDto{
    //姓名
    private String name;

    //手机号码
    private String phone;

    //开始时间
    private Date startTime;
}
