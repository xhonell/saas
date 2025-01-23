package com.xhonell.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.Date;

/**
 * program: saas
 * ClassName AdminQueryDto
 * description:
 * author: xhonell
 * create: 2025年01月21日14时17分
 * Version 1.0
 **/
@ApiModel("查询信息")
@Data
public class AdminQueryDto extends BaseQueryDto{
    @ApiModelProperty("用户姓名")
    //姓名
    private String name;

    //手机号码
    @ApiModelProperty("用户手机号")
    private String phone;

    //开始时间
    @ApiModelProperty("创建时间")
    private Date startTime;
}
