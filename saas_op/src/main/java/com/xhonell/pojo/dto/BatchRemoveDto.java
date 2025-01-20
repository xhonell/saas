package com.xhonell.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * program: saas
 * ClassName BatchRemoveDto
 * description:
 * author: xhonell
 * create: 2025年01月19日19时19分
 * Version 1.0
 **/
@Data
public class BatchRemoveDto implements Serializable {
    private List<Long> ids;
}
