package com.sky.controller;

import com.sky.dto.RemoteUserDTO;
import com.sky.feign.UserServiceFeign;
import com.sky.params.RegisterParams;
import com.sky.service.RegisterService;
import com.sky.utils.TsmsUtil;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sky
 * @create 2021-12-22 16:11
 */
@RestController
@Api("用户注册的控制器")
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private TsmsUtil tsmsUtil;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private RegisterService registerService;

    @PostMapping("/sendRegisterMail")
    public R sendMail(@RequestParam String phone) {
        // 发送验证码
        try {
            // 查询用户是否存在
            RemoteUserDTO user = userServiceFeign.getUserByPhone(phone);
            if (null != user) {
                return R.fail("该用户已注册");
            }
            return R.toAjax(tsmsUtil.sendSMS(phone, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.fail("发送验证码失败");
    }

    @PostMapping()
    @ApiOperation("用户注册")
    public R register(@RequestBody @Validated RegisterParams params) {
        int i = this.registerService.register(params);
        return i > 0 ? R.success("用户注册成功") : R.fail("手机号或验证码有误!!!");
    }

}
