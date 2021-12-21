package com.sky.controller;

import com.alibaba.fastjson.JSON;
import com.sky.aspectj.enums.BusinessStatus;
import com.sky.aspectj.enums.BusinessType;
import com.sky.aspectj.enums.OperatorType;
import com.sky.domain.LogOperInfo;
import com.sky.params.RegisterParams;
import com.sky.service.LogOperInfoService;
import com.sky.utils.AddressUtils;
import com.sky.utils.IpUtils;
import com.sky.utils.ServletUtils;
import com.sky.vo.R;
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

import java.util.Date;

/**
 * @author sky
 * @create 2021-12-01 17:30
 */
@RestController
@Api(tags = "用户登录的控制器")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LogOperInfoService logOperInfoService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public R login(@RequestBody @Validated LoginParams params) {
        LoginUser loginUser = null;
        LogOperInfo logOperInfo = this.createLogOperInfo(params);
        try {
            loginUser = loginService.login(params);
            logOperInfo.setJsonResult(JSON.toJSONString(R.success()));
        } catch (Exception e) {
            e.printStackTrace();
            logOperInfo.setJsonResult(JSON.toJSONString(R.fail()));
            logOperInfo.setStatus(String.valueOf(BusinessStatus.FAIL.ordinal()));
            logOperInfo.setErrorMsg(e.getMessage());
        }
        this.logOperInfoService.save(logOperInfo);
        return R.success(loginUser);
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public R register(@RequestBody @Validated RegisterParams params) {

        return null;
    }

    private LogOperInfo createLogOperInfo(LoginParams params) {
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
        logOperInfo.setOperatorType(String.valueOf(OperatorType.MEMBER.ordinal()));

        return logOperInfo;
    }
}
