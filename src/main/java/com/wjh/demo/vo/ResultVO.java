package com.wjh.demo.vo;

import com.wjh.demo.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回的数据格式
 * author wjh
 */
@Getter
@Setter
@ApiModel("统一返回数据格式")
public class ResultVO<T> {

    @ApiModelProperty(value = "状态码，1代表操作成功，其他表示操作失败")
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    @ApiModelProperty(value = "说明")
    private String msg;

    @ApiModelProperty(value = "具体数据")
    private T data;

    public ResultVO(String msg) {
        this(msg, ResultCodeEnum.SUCCESS);
    }

    public ResultVO(ResultCodeEnum code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public ResultVO(T data) {
        this(ResultCodeEnum.SUCCESS.getMsg(), ResultCodeEnum.SUCCESS, data);
    }

    public ResultVO(String msg, ResultCodeEnum code) {
        this.code = code.getCode();
        this.msg = msg;
    }

    public ResultVO(String msg, ResultCodeEnum code, T data) {
        this.code = code.getCode();
        this.msg = msg;
        this.data = data;
    }


}