package com.sky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author sky
 * @create 2021-11-20 16:39
 */
@RestController
public class UserInfoController {

    /**
     * 当前的登录的用户对象
     */
    @GetMapping("/user/info")
    public Principal userInfo(Principal principal) {
        // 使用ThreadLocal来实现的
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return principal;
    }

}
