package com.xhonell.exception;

import com.xhonell.result.ResultEnum;
import lombok.Data;

/**
 * program: saas
 * ClassName BizException
 * description:
 * author: xhonell
 * create: 2025年01月16日18时21分
 * Version 1.0
 **/
public class BizException extends RuntimeException{
    private ResultEnum resultEnum;

    public BizException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
