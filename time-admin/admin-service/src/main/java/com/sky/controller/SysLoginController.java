package com.sky.controller;

import com.alibaba.fastjson.JSON;
import com.sky.aspectj.annotation.Log;
import com.sky.aspectj.enums.BusinessStatus;
import com.sky.aspectj.enums.BusinessType;
import com.sky.aspectj.enums.OperatorType;
import com.sky.constants.Constants;
import com.sky.constants.HttpStatus;
import com.sky.domain.LogOperInfo;
import com.sky.dto.LoginResultDTO;
import com.sky.params.LoginInParams;
import com.sky.service.LogOperInfoService;
import com.sky.service.SysLoginService;
import com.sky.utils.AddressUtils;
import com.sky.utils.IpUtils;
import com.sky.utils.ServletUtils;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    @Autowired
    private LogOperInfoService logOperInfoService;

    @PostMapping("/login")
    @ApiOperation(value = "后台管理人员登录")
    public R login(@RequestBody @Validated LoginInParams params) {
        R ajax = R.success();
        LogOperInfo logOperInfo = createLogOperInfo(params);
        try {

            // 设置的登陆返回值
            LoginResultDTO dto = this.loginService.login(params.getUsername(), params.getPassword());
            ajax.put(Constants.TOKEN, dto.getToken());
            ajax.put(Constants.MENUS, dto.getMenus());
            ajax.put(Constants.AUTHORITIES, dto.getAuthorities());

            logOperInfo.setJsonResult(JSON.toJSONString(R.success()));
        } catch (Exception e) {
            ajax = R.error(HttpStatus.ERROR, "用户名或密码不正确");
            logOperInfo.setJsonResult(JSON.toJSONString(ajax));
            logOperInfo.setStatus(String.valueOf(BusinessStatus.FAIL.ordinal()));
            logOperInfo.setErrorMsg(e.getMessage());
        }
        logOperInfoService.save(logOperInfo);
        return ajax;
    }

    private LogOperInfo createLogOperInfo(LoginInParams params) {
        LogOperInfo logOperInfo = new LogOperInfo();
        logOperInfo.setTitle("登录");
        logOperInfo.setBusinessType(String.valueOf(BusinessType.LOGIN.ordinal()));
        logOperInfo.setOperParam("账号: " + params.getUsername());

        logOperInfo.setStatus(String.valueOf(BusinessStatus.SUCCESS.ordinal()));

        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        logOperInfo.setOperIp(ip);
        String address = AddressUtils.getRealAddressByIP(ip);
        logOperInfo.setOperLocation(address);

        logOperInfo.setOperTime(new Date());
        logOperInfo.setOperatorType(String.valueOf(OperatorType.OTHER.ordinal()));

        return logOperInfo;
    }
}
