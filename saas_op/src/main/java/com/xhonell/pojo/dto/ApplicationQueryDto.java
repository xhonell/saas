package com.xhonell.pojo.dto;

import lombok.Data;

/**
 * program: saas
 * ClassName ApplicationQueryDto
 * description:
 * author: xhonell
 * create: 2025年01月20日18时29分
 * Version 1.0
 **/
@Data
public class ApplicationQueryDto extends BaseQueryDto{
    private String name;
    private Integer status;
    private Long tenementId;
}
