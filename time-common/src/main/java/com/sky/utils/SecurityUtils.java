package com.sky.utils;

import com.sky.domain.SimpleUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 安全工具类
 * @author sky
 * @create 2021-11-27 15:44
 */
public class SecurityUtils {
    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public static SimpleUser getUser() {
        Authentication authentication = getAuthentication();
        return getUser(authentication);
    }

    /**
     * 获取用户
     */
    public static SimpleUser getUser(Authentication authentication) {
        String userId = authentication.getPrincipal().toString();
        return new SimpleUser(Long.valueOf(userId));
    }

}
