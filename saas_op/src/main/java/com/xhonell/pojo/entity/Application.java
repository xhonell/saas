package com.xhonell.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * program: saas
 * ClassName Application
 * description:
 * author: xhonell
 * create: 2025年01月20日18时11分
 * Version 1.0
 **/
@Data
@TableName("op_application")
public class Application implements Serializable {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;
    private String version;
    private String image;
    private String hosts;
    private Long tenementId;
    private Integer status;
    private Date created;
    private Date updated;
}
