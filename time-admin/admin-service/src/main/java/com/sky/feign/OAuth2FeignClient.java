package com.sky.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sky
 * @create 2021-11-21 16:38
 */
@FeignClient(value = "authorization-server")
public interface OAuth2FeignClient {

    @PostMapping("/oauth/token")
    ResponseEntity<JwtToken> getToken(
            @RequestParam("grant_type") String grantType, // 授权类型
            @RequestParam("username") String username, // 用户名
            @RequestParam("password") String password, // 用户的密码
            @RequestParam("login_type") String loginType,  // 登录的类型
            @RequestHeader("Authorization") String basicToken // Basic dGltZS1hcGk6dGltZS1zZWNyZXQ= 由第三方客户端信息加密出现的值
    );

}
