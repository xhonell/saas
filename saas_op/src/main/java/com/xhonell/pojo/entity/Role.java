package com.xhonell.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * program: saas
 * ClassName Role
 * description:
 * author: xhonell
 * create: 2025年01月23日21时01分
 * Version 1.0
 **/
@Data
@TableName("op_role")
public class Role implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date created;
    private Date updated;
}
