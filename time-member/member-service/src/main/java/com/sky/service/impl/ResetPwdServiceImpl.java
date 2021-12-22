package com.sky.service.impl;

import com.sky.constants.Constants;
import com.sky.params.ResetPwdParams;
import com.sky.service.ResetPwdService;
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

    @Override
    public int resetPwd(ResetPwdParams params) {
        // 从 redis 中获取验证码
        String yzm = redisTemplate.opsForValue().get(Constants.REDIS_KEY_SMS_CODE_KEY + params.getPhone());

        if (null == yzm || !yzm.equals(params.getYzm())) {
            // 如果验证码为空，或者验证码不正确
            return -1;
        }

        // 远程调用 admin-serve 进行重置密码

        return 0;
    }
}
