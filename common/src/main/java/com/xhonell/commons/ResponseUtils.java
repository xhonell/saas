package com.xhonell.commons;

import com.xhonell.result.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * program: saas
 * ClassName ResponseUtils
 * description:
 * author: xhonell
 * create: 2025年01月20日17时45分
 * Version 1.0
 **/
public class ResponseUtils {

    /**
     * 返回错误信息Json数据给前端
     * @param response 响应对象
     * @param str 需要相应的数据
     */
    public static void responseToJson(HttpServletResponse response, String str) {
        try {
            response.setContentType("application/json;charset=utf-8");
            String s = JsonUtils.objectToJson(Result.fail(50000,str));
            response.getWriter().write(s);
        } catch (IOException e) {
            throw new RuntimeException("Json数据返回失败");
        }
    }

    /**
     * 返回Result的json数据给前端
     * @param response 响应留
     * @param result 结果集
     */
    public static void responseToJson(HttpServletResponse response, Result result) {
        try {
            response.setContentType("application/json;charset=utf-8");
            String s = JsonUtils.objectToJson(result);
            response.getWriter().write(s);
        } catch (IOException e) {
            throw new RuntimeException("Json数据返回失败");
        }
    }
}
