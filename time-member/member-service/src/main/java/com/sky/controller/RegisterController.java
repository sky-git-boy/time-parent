package com.sky.controller;

import com.sky.dto.RemoteUserDTO;
import com.sky.feign.UserServiceFeign;
import com.sky.params.RegisterParams;
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

    @PostMapping("/sendRegisterMail")
    public R sendMail(@RequestParam String phone) {
        // 发送验证码
        String res = null;
        try {
            // 查询用户是否存在
            RemoteUserDTO user = userServiceFeign.getUserByPhone(phone);
            if (null != user) {
                return R.fail("该用户已注册");
            }
            res = tsmsUtil.sendSMS(phone, true);
            return R.success(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.fail(res);
    }

    @PostMapping()
    @ApiOperation("用户注册")
    public R register(@RequestBody @Validated RegisterParams params) {


       return R.success();
    }

}
