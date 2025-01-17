package com.xhonell.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * program: xhonell
 * ClassName Item
 * description:
 * author: xhonell
 * create: 2025年01月14日19时24分
 * Version 1.0
 **/
@Data
@Component("item")
public class Item {
    private Integer id;

    private String name;

    private Float price;

    private String pic;

    private Date createtime;

    private String detail;

    public Item() {
    }

    public Item(Integer id, String name, Float price, String pic, Date createtime, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.createtime = createtime;
        this.detail = detail;
    }
}
