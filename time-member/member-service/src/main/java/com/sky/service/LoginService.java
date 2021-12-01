package com.sky.service;

import com.sky.model.LoginUser;
import com.sky.params.LoginParams;

/**
 * @author sky
 * @create 2021-12-01 17:31
 */
public interface LoginService {

    /**
     * 会员的登录
     * @param params 登录的表单参数
     * @return  登录的结果
     */
    LoginUser login(LoginParams params);
}
