package com.xhonell.interceptor;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.xhonell.commons.AdminThreadLocal;
import com.xhonell.commons.ResponseUtils;
import com.xhonell.commons.TokenUtils;
import com.xhonell.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * program: saas
 * ClassName MyInterceptor
 * description:
 * author: xhonell
 * create: 2025年01月16日18时27分
 * Version 1.0
 **/
public class AuthInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("token");
        log.debug("服务器获取的到的token为:{}",token);

        //判断token是否存在
        if (StrUtil.isEmpty(token)) {
            Result result = Result.fail(20002, "token不能为空!");
            ResponseUtils.responseToJson(httpServletResponse,result);
            log.error("token不能为空!");
            return false;
        }

        //解析令牌
        if (!JWTUtil.verify(token, TokenUtils.KEY.getBytes())){
            Result result = Result.fail(20003, "jwt令牌不合法!");
            ResponseUtils.responseToJson(httpServletResponse,result);
            log.error("{}:jwt令牌不合法!",token);
            return false;
        }


        JWT jwt = JWTUtil.parseToken(token);
        NumberWithFormat expire = (NumberWithFormat) jwt.getPayload("expire");

        //判断token是否失效
        if (expire.longValue() < System.currentTimeMillis()) {
            Result result = Result.fail(20004, "登录失效!");
            ResponseUtils.responseToJson(httpServletResponse,result);
            log.error("{}:登录失效!",token);
            return false;
        }

        //4.获取到其他载荷信息
        Map<String,Object> map=new HashMap<>();
        map.put("id",jwt.getPayload("id"));
        map.put("name",jwt.getPayload("name"));
        map.put("phone",jwt.getPayload("phone"));


        //5.绑定用户信息到当前线程
        AdminThreadLocal.set(map);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
