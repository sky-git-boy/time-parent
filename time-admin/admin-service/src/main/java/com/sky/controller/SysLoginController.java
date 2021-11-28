package com.sky.controller;

import com.sky.constants.Constants;
import com.sky.constants.HttpStatus;
import com.sky.dto.LoginResultDTO;
import com.sky.params.LoginInParams;
import com.sky.service.SysLoginService;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public R login(@RequestBody @Validated LoginInParams params) {
        R ajax = R.success();
        try {

            // 设置的登陆返回值
            LoginResultDTO dto = this.loginService.login(params.getUsername(), params.getPassword());
            ajax.put(Constants.TOKEN, dto.getToken());
            ajax.put(Constants.MENUS, dto.getMenus());
            ajax.put(Constants.AUTHORITIES, dto.getAuthorities());

        } catch (Exception e) {
            ajax = R.error(HttpStatus.ERROR, "用户名或密码不正确");
        }
        return ajax;
    }
}
