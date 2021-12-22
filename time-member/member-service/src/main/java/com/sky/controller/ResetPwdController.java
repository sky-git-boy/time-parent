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
        try {
            // 查询用户是否存在
            RemoteUserDTO user = userServiceFeign.getUserByPhone(phone);

            if (null == user) {
                return R.fail("该手机号并未注册");
            }

            return R.toAjax(tsmsUtil.sendSMS(phone, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.fail("发送验证码失败");
    }

    @PostMapping("/resetPwd")
    public R resetPwd(@RequestBody ResetPwdParams params) {
        try {
            RemoteUserDTO user = userServiceFeign.getUserByPhone(params.getPhone());
            params.setUserId(user.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = this.service.resetPwd(params);
        return i > 0 ? R.success("重置密码成功") : R.fail("手机号或验证码有误!!!");
    }

}
