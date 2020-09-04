package com.common.enums;


import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * @project-name: 返回结构
 * @author: xiongh
 * @date: 2020/2/7 9:40
 * @version: 1.0
 */
@AllArgsConstructor
public enum ResultResponseEnum implements Serializable {
    SUCCESS(200, "ok"),
    SYSTEM_ERROR(1000, "系统异常"),
    NO_DATA(1001, "暂无数据"),
    OPERATION_FAILED(1002, "操作失败"),
    ILLEGAL_PARA_METE(1003, "参数非法"),
    REQUIRED_PARAMETERS_ARE_MISSING(1004, "必要参数缺失"),
    REQUEST_BODY_EXCEPTION(1005, "请求体异常,非JSON"),
    JTW_EXCEPTION(1006, "JWT异常"),
    AUTHORIZATION_EXCEPTION(1007, "Authorization 异常，疑似被篡改"),
    //2000-2100 表示用户相关
    USER_PASSWORD_IS_WRONG(2001, "用户密码错误"),
    USER_NOT_AUTHORIZATION(2002, "Authorization 丢失，请重新登录");

    private static final long serialVersionUID = -5215526919171165L;

    ResultResponseEnum(ResultResponseEnum responseEnum, String desc) {
        this.code = responseEnum.getCode();
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private Integer code;

    private String desc;

}
