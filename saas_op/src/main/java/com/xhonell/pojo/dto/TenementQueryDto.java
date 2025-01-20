package com.xhonell.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * program: saas
 * ClassName TenementQueryDto
 * description:
 * author: xhonell
 * create: 2025年01月18日22时12分
 * Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenementQueryDto extends BaseQueryDto {
    private String companyName;
    private Long businessId;
}
