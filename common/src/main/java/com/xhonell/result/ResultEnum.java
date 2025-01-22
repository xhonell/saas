package com.xhonell.result;


import lombok.Getter;
import lombok.Setter;

@Getter
public enum ResultEnum {

    REQUEST_SUCCESS(0,"请求成功!"),
    UNKNOWN_EXCEPTION(50000,"对不起，系统繁忙，请稍后再来!"),
    TOKEN_EMPTY(20001,"Token不能为空!"),
    TOKEN_VALIDATE(20002,"jwt令牌不合法!"),
    TOKEN_EXPIRE(20003,"登录失效!"),
    USER_NOT_EMPTY(20004,"用户信息不能为空!"),
    USERNAME_NOT_EMPTY(20005,"用户名不能为空!"),
    PHONE_NOT_EMPTY(20006,"手机号码不能为空!"),
    EMAIL_NOT_EMPTY(20007,"邮箱不能为空!"),
    USERNAME_EXITS(20008,"用户名已存在!"),
    PHONE_EXITS(20009,"手机号码已存在!"),
    EMAIL_EXITS(20010,"邮箱已存在!"),
    USERNAME_OR_PASSWORD_ERROR(20011,"用户名或密码错误!"),
    IMAGE_TYPE_ERROR(20012,"上传图片的格式不合法!");

    private final String message;
    private final Integer code;

    ResultEnum(Integer code, String message ) {
        this.message = message;
        this.code = code;
    }

}