package com.sky.service;

import com.sky.dto.LoginResultDTO;

/**
 * @author sky
 * @create 2021-11-21 16:35
 */
public interface SysLoginService {
    // 登录
    LoginResultDTO login(String username, String password);
}
