package com.xhonell.result;

import lombok.Data;

/**
 * program: saas
 * ClassName Result
 * description:
 * author: xhonell
 * create: 2025年01月19日15时40分
 * Version 1.0
 **/
@Data
public class Result <T> {
    private Integer code;
    private String msg;
    private Long count;
    private T data;

    /**
     * 返回查询成功带条目数的操作结果
     * @param count 条目数
     * @param data 查询的数据
     * @return 结果集
     */
    public static Result success(Long count, Object data) {
        Result result = new Result();
        result.code = 0;
        result.msg = "操作成功";
        result.count = count;
        result.data = data;
        return result;
    }

    /**
     * 返回操作成功不带条目数的操作结果
     * @param data 返回的数据
     * @return 结果集
     */
    public static Result success(Object data) {
        return success(null, data);
    }

    /**
     * 返回默认的操作成功结果
     * @return 结果集
     */
    public static Result success() {
        return success(null, null);
    }

    /**
     * 返回操作失败的结果
     * @param code 失败码
     * @param msg 失败信息
     * @return 结果集
     */
    public static Result fail(Integer code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

    /**
     * 返回进行判断的结果集
     * @param isSuccess 是否成功
     * @return 结果集
     */
    public static Result judge(Boolean isSuccess) {
        return isSuccess ? success() : fail(20000, "操作失败");
    }
}
