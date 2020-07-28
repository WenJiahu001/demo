package com.wjh.demo.entity.dto;

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
public class UserMasterDTO{
@ApiModelProperty(value = "用户账号")
    private String name;
@ApiModelProperty(value = "用户密码")
    private String pwd;
}