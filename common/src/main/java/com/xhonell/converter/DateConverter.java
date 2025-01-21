package com.xhonell.converter;

import com.alibaba.druid.util.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * program: saas
 * ClassName DateConver
 * description:
 * author: xhonell
 * create: 2025年01月16日17时57分
 * Version 1.0
 **/
public class DateConverter implements Converter<String, Date> {
    /**
     * 将时间转化为指定格式
     * @param timeStr 要专家的时间字符串
     * @return 转化后的时间结果
     */
    @Override
    public Date convert(String timeStr) {
        //判断时间字符串为空
        if (StringUtils.isEmpty(timeStr)) return null;

        try{
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(timeStr);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("日期转换失败!");
        }
    }
}
