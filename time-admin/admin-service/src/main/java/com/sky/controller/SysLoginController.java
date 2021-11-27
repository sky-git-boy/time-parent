package com.sky.controller;

import com.sky.dto.LoginResultDTO;
import com.sky.params.LoginInParams;
import com.sky.service.SysLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 *
 * @author sky
 * @create 2021-11-21 16:34
 */
@RestController
@Api(tags = "登录的控制器")
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "后台管理人员登录")
    public LoginResultDTO login(@RequestBody LoginInParams params) {
        return this.loginService.login(params.getUsername(), params.getPassword());
    }
}
