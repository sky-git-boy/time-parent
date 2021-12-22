package com.sky.service.impl;

import com.sky.constants.Constants;
import com.sky.params.RegisterParams;
import com.sky.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 用户注册
 * @author sky
 * @create 2021-12-22 16:16
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public int register(RegisterParams params) {

        // 从 redis 中获取验证码
        String yzm = redisTemplate.opsForValue().get(Constants.REDIS_KEY_SMS_CODE_KEY + params.getPhone());

        if (null == yzm || !yzm.equals(params.getYzm())) {
            // 如果验证码为空或验证码不相等
            return -1;
        }

        // 远程调用 admin-serve ，进行注册

        return 0;
    }
}