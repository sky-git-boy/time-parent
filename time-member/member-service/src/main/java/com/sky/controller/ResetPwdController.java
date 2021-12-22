package com.sky.controller;

import com.sky.dto.RemoteUserDTO;
import com.sky.feign.UserServiceFeign;
import com.sky.params.ResetPwdParams;
import com.sky.service.ResetPwdService;
import com.sky.utils.TsmsUtil;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 重置密码控制器
 * @author sky
 * @create 2021-12-22 14:31
 */
@RestController
@RequestMapping("reset")
public class ResetPwdController {

    @Autowired
    private TsmsUtil tsmsUtil;

    @Autowired
    private ResetPwdService service;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @PostMapping("/sendResetMail")
    public R sendMail(@RequestParam String phone) {

        // 发送验证码
        String res = null;
        try {
            // 查询用户是否存在
            RemoteUserDTO user = userServiceFeign.getUserByPhone(phone);
            System.out.println(user);

            if (null == user) {
                return R.fail("该手机号并未注册");
            }

            res = tsmsUtil.sendSMS(phone, false);
            return R.success(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.fail(res);
    }

    @PostMapping("/resetPwd")
    public R resetPwd(@RequestBody ResetPwdParams params) {
        return R.toAjax(this.service.resetPwd(params));
    }

}
