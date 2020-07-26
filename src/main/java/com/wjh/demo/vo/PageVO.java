package com.wjh.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WJH
 * @date 2020/7/5
 */
@Data
@ApiModel("分页信息")
public class PageVO {
    @ApiModelProperty(value = "页码")
    private int pi;
    @ApiModelProperty(value = "每页数量")
    private int ps;
}
