package com.wjh.demo.enums;

/**
 * 统一封装响应码
 * author wjh
 */
public enum ResultCodeEnum {

    ERROR(-1, "-1:数据处理异常，本次请求没有成功~"),
    FAILED(0, "操作失败"),
    SUCCESS(1, "操作成功"),
    VALIDATE_FAILED(2, "参数校验失败"),
    METHOD_FAILED(3, "嘻嘻嘻，请求方法错误");

    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}