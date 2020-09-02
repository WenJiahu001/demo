package com.wjh.demo.entity.edto;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * 账号表(UserMaster)查询专用实体类
 *
 * @author wjh
 * @since 2020-08-31 14:48:37
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
    @ApiModelProperty(value = "用户密码")
    private String pwd;
    
}