package com.xzj.common.config;


/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/9/3 17:36
 */
public enum ExceptionCodeEnume {
    UNKNOW_EXCEPTION(1002,"系统异常"),
    VAILD_EXCEPTION(10001, "参数格式检验异常");

    private int code;
    private String msg;

    ExceptionCodeEnume(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
