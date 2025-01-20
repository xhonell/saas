package com.xhonell.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * program: saas
 * ClassName Tenement
 * description:
 * author: xhonell
 * create: 2025年01月17日12时58分
 * Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("op_tenement")
public class Tenement implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String companyName;
    private Integer tenementType;
    private String province;
    private String city;
    private String area;
    private String address;
    private String linkman;
    private String concatWay;
    private String email;
    private Long businessId;
    private String description;
    private String logImage;
    private Date created;
    private Date updated;
}
