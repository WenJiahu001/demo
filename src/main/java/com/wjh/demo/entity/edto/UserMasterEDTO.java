package com.wjh.demo.entity.edto;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 账号表(UserMaster)查询专用实体类
 *
 * @author wjh
 * @since 2020-08-03 16:22:44
 */
@Data
@ApiModel("账号表编辑专用实体类")
public class UserMasterEDTO{
    @ApiModelProperty(value = "id 修改时必须传,新增可以不传")
    private Integer id;
    
    @NotNull(message = "用户账号不能为空")
    @ApiModelProperty(value = "用户账号")
    private String name;
    
    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    @ApiModelProperty(value = "用户密码")
    private String pwd;
    
}