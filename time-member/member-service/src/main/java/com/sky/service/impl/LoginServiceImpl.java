package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.sky.constants.Constants;
import com.sky.feign.JwtToken;
import com.sky.feign.OAuth2FeignClient;
import com.sky.model.LoginUser;
import com.sky.params.LoginParams;
import com.sky.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author sky
 * @create 2021-12-01 17:31
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private OAuth2FeignClient client;

    @Value("${basic.token:Basic dGltZS1hcGk6dGltZS1zZWNyZXQ=}")
    private String basicToken;

    @Autowired
    private StringRedisTemplate strRedisTemplate;

    @Override
    public LoginUser login(LoginParams params) {
        log.info("用户{}开始登录", params.getUsername());
        LoginUser loginUser = null;
        // 登录就是使用用户名和密码换一个token 而已--->远程调用-> authorization-server
        ResponseEntity<JwtToken> tokenResponseEntity = client.getToken(Constants.grantType, params.getUsername(), params.getPassword(), Constants.MemberType, basicToken);
        if (tokenResponseEntity.getStatusCode() == HttpStatus.OK) {
            JwtToken jwtToken = tokenResponseEntity.getBody();
            log.info("远程调用成功,结果为 {}", JSON.toJSONString(jwtToken, true));
            // token 必须包含bearer
            loginUser = new LoginUser(params.getUsername(), jwtToken.getExpiresIn(), jwtToken.getTokenType() + " " + jwtToken.getAccessToken(), jwtToken.getRefreshToken());
            // 使用网关解决登出的问题:
            // token 是直接存储的
            strRedisTemplate.opsForValue().set(jwtToken.getAccessToken(), "", jwtToken.getExpiresIn(), TimeUnit.SECONDS);
        }
        return loginUser;
    }
}
