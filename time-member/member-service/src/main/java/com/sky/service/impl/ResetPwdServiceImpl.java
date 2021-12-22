package com.sky.service.impl;

import com.sky.constants.Constants;
import com.sky.dto.RemoteUserDTO;
import com.sky.feign.UserServiceFeign;
import com.sky.params.ResetPwdParams;
import com.sky.service.ResetPwdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @create 2021-12-22 15:55
 */
@Service
public class ResetPwdServiceImpl implements ResetPwdService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public int resetPwd(ResetPwdParams params) {
        // 从 redis 中获取验证码
        String yzm = redisTemplate.opsForValue().get(Constants.REDIS_KEY_RESETPWD_SMS_KEY + params.getPhone());

        if (null == yzm || !yzm.equals(params.getYzm())) {
            // 如果验证码为空，或者验证码不正确
            return -1;
        }

        // 远程调用 admin-serve 进行重置密码
        try {
            RemoteUserDTO dto = new RemoteUserDTO();
            BeanUtils.copyProperties(params, dto);
            return userServiceFeign.resetPwd(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
