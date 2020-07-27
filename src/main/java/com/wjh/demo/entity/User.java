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
 * 账号表(User)实体类
 *
 * @author wjh
 * @since 2020-07-27 17:51:06
 */
@Data
@ApiModel("账号表实体类")
public class User implements Serializable {

        
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
        @Column(name = "`createtime`")
    private Long createtime;

            @ApiModelProperty(value = "修改时间")
        @Column(name = "`modifytime`")
    private Long modifytime;

            @ApiModelProperty(value = "删除状态 1有效 2已删除")
        @Column(name = "`status`")
    private Byte status;

    private static final long serialVersionUID = 469089094061720519L;

}