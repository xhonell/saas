package com.xhonell.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * program: saas
 * ClassName Admin
 * description:
 * author: xhonell
 * create: 2025年01月21日14时13分
 * Version 1.0
 **/
@Data
@TableName("op_admin")
public class Admin implements Serializable {

    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String image;
    private String salt;
    private String face;
    private Date created;
    private Date updated;
}
