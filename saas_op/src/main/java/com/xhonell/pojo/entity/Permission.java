package com.xhonell.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * program: saas
 * ClassName Perssion
 * description:
 * author: xhonell
 * create: 2025年01月23日20时58分
 * Version 1.0
 **/
@Data
@TableName("op_permission")
public class Permission implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String uri;
    private String perms;
    private Date created;
    private Date updated;
}
