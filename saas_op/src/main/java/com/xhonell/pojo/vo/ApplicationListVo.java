package com.xhonell.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * program: saas
 * ClassName ApplicationListVo
 * description:
 * author: xhonell
 * create: 2025年01月20日20时27分
 * Version 1.0
 **/
@Data
public class ApplicationListVo {
    private Long id;
    private String name;
    private String version;
    private String image;
    private String hosts;
    private String companyName;;
    private Integer status;
    private Date created;
    private Date updated;
}
