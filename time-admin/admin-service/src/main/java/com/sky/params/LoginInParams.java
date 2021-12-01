package com.sky.params;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户登录参数
 * @author sky
 * @create 2021-11-25 16:15
 */
@Data
public class LoginInParams {

    @NotBlank(message = "用户名不能为空")
    String username; // 用户名称

    @NotBlank(message = "用户密码不能为空")
    String password; // 用户的密码
}
