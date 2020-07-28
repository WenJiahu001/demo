package com.wjh.demo.entity.edto;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 账号表(UserMaster)查询专用实体类
 *
 * @author wjh
 * @since 2020-07-28 16:02:40
 */
@Data
@ApiModel("账号表查询专用实体类")
public class UserMasterEDTO{
    @ApiModelProperty(value = "id 修改时必须传,新增可以不传")
    private Integer id;
    @ApiModelProperty(value = "用户账号")
    private String name;
    @ApiModelProperty(value = "用户密码")
    private String pwd;
}