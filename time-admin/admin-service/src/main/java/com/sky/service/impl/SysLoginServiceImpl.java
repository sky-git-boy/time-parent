package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.esotericsoftware.minlog.Log;
import com.sky.constants.Constants;
import com.sky.domain.SysMenu;
import com.sky.dto.LoginResultDTO;
import com.sky.feign.JwtToken;
import com.sky.feign.OAuth2FeignClient;
import com.sky.service.SysLoginService;
import com.sky.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 登录实现
 *
 * @author sky
 * @create 2021-11-21 16:35
 */
@Service
@Slf4j
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private OAuth2FeignClient client;

    @Value("${basic.token:Basic dGltZS1hcGk6dGltZS1zZWNyZXQ=}")
    private String basicToken;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 登录的实现
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录返回值
     */
    @Override
    public LoginResultDTO login(String username, String password) {
        Log.info("用户{}开始登录", username);
        // 远程调用获取用户token
        ResponseEntity<JwtToken> responseEntity =
                client.getToken(Constants.grantType, username, password, Constants.loginType, basicToken);

        // 判断返回的jwtToken是否合法
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new ApiException(ApiErrorCode.FAILED);
        }

        // 获取用户的 token
        JwtToken jwtToken = responseEntity.getBody();
        log.info("远程调用授权服务器成功,获取的token为{}", JSON.toJSONString(jwtToken, true));

        String token = jwtToken.getAccessToken();

        // 将token转成json格式
        String jwtJsonStr = JwtHelper.decode(token).getClaims();
        JSONObject jwtJson = JSON.parseObject(jwtJsonStr);

        // 查询我们的菜单数据
        Long userId = Long.valueOf(jwtJson.getString("user_name"));
        List<String> menuTypes = new ArrayList<>();
        menuTypes.add(Constants.MENU_TYPE_M);
        menuTypes.add(Constants.MENU_TYPE_C);
        List<SysMenu> menus = sysMenuService.getMenusByUserId(userId, menuTypes);

        // 从token中获取我们的权限数据
        JSONArray authoritiesJsonArray = jwtJson.getJSONArray("authorities");
        // 组装我们的权限数据
        List<SimpleGrantedAuthority> authorities = authoritiesJsonArray.stream()
                .map(authorityJson -> new SimpleGrantedAuthority(authorityJson.toString()))
                .collect(Collectors.toList());

        // 将该token存储在redis里面，配置我们的网关做jwt验证的操作
        redisTemplate.opsForValue().set(token, "", jwtToken.getExpiresIn(), TimeUnit.SECONDS);

        // 我们返回给前端的Token 数据，少一个bearer：
        return new LoginResultDTO(jwtToken.getTokenType() + " " + token, menus, authorities);
    }
}
