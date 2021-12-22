package com.sky.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author sky
 * @create 2021-12-20 11:55
 */
@Data
public class RegisterParams {

    @ApiModelProperty(value = "用户名称")
    @NotBlank(message = "账号不能为空")
    private String phone;

    @ApiModelProperty(value = "用户邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "验证码")
    @NotBlank(message = "验证码不能为空")
    private String yzm;

    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "密码不能为空")
    private String password;

}
