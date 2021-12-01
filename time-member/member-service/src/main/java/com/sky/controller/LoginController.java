package com.sky.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sky.model.LoginUser;
import com.sky.params.LoginParams;
import com.sky.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @create 2021-12-01 17:30
 */
@RestController
@Api(tags = "用户登录的控制器")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public R<LoginUser> login(@RequestBody @Validated LoginParams params){
        LoginUser loginUser =  loginService.login(params) ;
        return R.ok(loginUser) ;
    }

}
