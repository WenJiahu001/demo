package com.wjh.demo.utils;


import com.wjh.demo.enums.ResultCodeEnum;
import com.wjh.demo.vo.ResultVO;

public class ReturnUtils {
    public static ResultVO success(String msg) {
        return new ResultVO<>(msg, ResultCodeEnum.SUCCESS);
    }

    public static ResultVO success(String msg, Object data) {
        return new ResultVO(msg, ResultCodeEnum.SUCCESS, data);
    }

    public static ResultVO failed(String msg) {
        return new ResultVO<>(msg, ResultCodeEnum.FAILED);
    }

}
