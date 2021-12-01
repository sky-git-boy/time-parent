package com.sky.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author sky
 * @create 2021-12-01 17:34
 */
@Data
public class LoginParams {

    @ApiModelProperty(value = "用户名称")
    @NotBlank(message = "账号不能为空")
    private String username;

    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户的uuid")
    private String uuid;

}
