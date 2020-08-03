package com.wjh.demo.entity.edto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

;

/**
 * 账号表(UserMaster)查询专用实体类  怕被自动生成覆盖掉，放在这里备用
 *
 * @author wjh
 * @since 2020-08-03 09:29:36
 */
@Data
@ApiModel("账号表编辑专用实体类")
public class UserMasterEDTOCOPY {
    @ApiModelProperty(value = "id 修改时必传")
    private Integer id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    @ApiModelProperty(value = "用户账号", required = true)
    private String name;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    @ApiModelProperty(value = "用户密码", required = true)
    private String pwd;

    @Size(min = 0, max = 200, message = "年龄校检不通过")
    @ApiModelProperty(value = "年龄", required = true)
    private int age;
}