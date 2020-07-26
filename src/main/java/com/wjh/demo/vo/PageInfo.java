package com.wjh.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("分页实体")
public class PageInfo<T> {
    @ApiModelProperty(value = "当前页")
    private int pageNum;
    @ApiModelProperty(value = "每页的数量")
    private int pageSize;
    @ApiModelProperty(value = "当前页的数量")
    private int size;
    @ApiModelProperty(value = "总页数")
    private int pages;
    @ApiModelProperty(value = "总数")
    private Long total;
    @ApiModelProperty(value = "列表数据")
    private List<T> list;

    public PageInfo(List<T> list) {
        com.github.pagehelper.PageInfo<T> p = new com.github.pagehelper.PageInfo<>(list);
        this.pageNum = p.getPageNum();
        this.pageSize = p.getPageSize();
        this.size = p.getSize();
        this.pages = p.getPages();
        this.setTotal(p.getTotal());
        this.setList(list);
    }

}
