package com.wjh.demo.entity;

import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 账号表(UserMaster)实体类
 *
 * @author wjh
 * @since 2020-08-03 09:29:36
 */
@Data
@ApiModel("账号表实体类")
public class UserMaster implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Integer id;
    @ApiModelProperty(value = "用户账号")
    @Column(name = "`name`")
    private String name;
    @ApiModelProperty(value = "用户密码")
    @Column(name = "`pwd`")
    private String pwd;
    @ApiModelProperty(value = "创建时间")
    @Column(name = "`createTime`")
    private Long createTime;
    @ApiModelProperty(value = "修改时间")
    @Column(name = "`modifyTime`")
    private Long modifyTime;
    @ApiModelProperty(value = "删除状态 1有效 2已删除")
    @Column(name = "`status`")
    private Byte status;

    private static final long serialVersionUID = 295053206816182726L;
}