package com.xhonell.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * program: saas
 * ClassName BaseQueryDto
 * description:
 * author: xhonell
 * create: 2025年01月18日22时13分
 * Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseQueryDto implements Serializable {
    private Integer page = 1;
    private Integer limit = 10;
}
