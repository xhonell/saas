package com.xhonell.exception;

/**
 * program: saas
 * ClassName BizException
 * description:
 * author: xhonell
 * create: 2025年01月16日18时21分
 * Version 1.0
 **/
public class BizException extends RuntimeException{
    private String message;

    public BizException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
