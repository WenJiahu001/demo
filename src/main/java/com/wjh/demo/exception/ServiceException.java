package com.wjh.demo.exception;

import lombok.Data;

/**
 * @author WJH
 * @date 2020/8/18
 */
@Data
public class ServiceException extends RuntimeException {
    private int code;
    private String msg;

    public ServiceException() {
        this(1002, "Service异常");
    }

    public ServiceException(String msg) {
        this(1002, msg);
    }

    public ServiceException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
