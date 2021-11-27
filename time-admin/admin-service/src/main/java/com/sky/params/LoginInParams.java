package com.sky.params;

import lombok.Data;

/**
 * 用户登录参数
 * @author sky
 * @create 2021-11-25 16:15
 */
@Data
public class LoginInParams {

    String username; // 用户名称
    String password; // 用户的密码
}
