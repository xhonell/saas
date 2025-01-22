package com.xhonell.exception;

import com.xhonell.commons.ResponseUtils;
import com.xhonell.result.ResultEnum;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * program: saas
 * ClassName ExceptionHandle
 * description: 全局异常处理器
 * author: xhonell
 * create: 2025年01月16日18时22分
 * Version 1.0
 **/
public class ExceptionHandle implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ResultEnum resultEnum ;

        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            resultEnum = bizException.getResultEnum();
        } else {
            resultEnum = ResultEnum.UNKNOWN_EXCEPTION;
        }

        ResponseUtils.responseToJson(httpServletResponse, resultEnum);

        return new ModelAndView();
    }
}
