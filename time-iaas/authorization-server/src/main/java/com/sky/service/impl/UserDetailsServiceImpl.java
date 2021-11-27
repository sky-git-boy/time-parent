package com.sky.service.impl;

import com.sky.constants.LoginConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sky
 * @create 2021-11-19 17:55
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        String loginType = attributes.getRequest().getParameter("login_type").toUpperCase(); // 获取用户登录类型
        if (StringUtils.isEmpty(loginType)) {
            throw new AuthenticationServiceException("登录类型不能为null");
        }

        UserDetails userDetails = null;

        try {

            String grantType = attributes.getRequest().getParameter("grant_type");
            // refresh_token 进行纠正
            if (LoginConstants.REFRESH_TYPE.equals(grantType.toUpperCase())) {
                username = adjustUsername(username);
            }

            loginType = loginType.equals(LoginConstants.ADMIN_TYPE) ? "0" : "1";

            userDetails = loadSysUserByUsername(username, loginType);

        } catch (UsernameNotFoundException | IncorrectResultSizeDataAccessException e) {
            System.out.println("用户【" + username + "】不存在");
        }

        return userDetails;
    }

    /**
     * 用户登录
     */
    private UserDetails loadSysUserByUsername(String username, String loginType) {
        // 使用用户名查询用户
        return jdbcTemplate.queryForObject(LoginConstants.QUERY_USER_BY_PHONE, (rs, rowNum) -> {
            if (rs.wasNull()) {
                throw new UsernameNotFoundException("用户【" + username + "】不存在");
            }

            long userId = rs.getLong("user_id"); // 用户的id
            String password = rs.getString("password"); // 用户的密码
            String status = rs.getString("status"); // 用户的状态
            String delFlag = rs.getString("del_flag"); // 删除标识
            String userType = rs.getString("user_type"); // 用户类别

            // 如果是后台登录，判断用户是否是后台用户
            if (loginType.equals("0") && !loginType.equals(userType)) {
                throw new UsernameNotFoundException("用户【" + username + "】不存在");
            }

            // 获取用户的权限
            Collection<? extends GrantedAuthority> permissions;

            try {
                permissions = getSysUserPermissions(userId);
            } catch (Exception e) {
                throw new RuntimeException("用户【" + username + "】无权限");
            }

            // 封装成一个UserDetails对象，返回
            return new User(
                    String.valueOf(userId), //使用id->username
                    password,
                    status.equals("0") && delFlag.equals("0"),
                    true,
                    true,
                    true,
                    permissions
            );
        }, username);
    }

    /**
     * 纠正用户的名称
     */
    private String adjustUsername(String username) {
        return this.jdbcTemplate.queryForObject(
                LoginConstants.QUERY_USER_BY_ID, String.class, username
        );
    }

    /**
     * 查询这个用户对应的权限
     * 通过用户的id 查询用户的权限
     */
    private Collection<? extends GrantedAuthority> getSysUserPermissions(long id) {
        // 1 当用户为超级管理员时，他拥有所有的权限数据
        String roleCode = jdbcTemplate.queryForObject(LoginConstants.QUERY_ROLE_CODE_SQL, String.class, id);
        List<String> permissions; // 菜单的权限标识

        if (LoginConstants.ADMIN_ROLE_CODE.equals(roleCode)) { // 超级用户 -> 所有权限
            permissions = jdbcTemplate.queryForList(LoginConstants.QUERY_ALL_PERMISSIONS, String.class);
        } else { // 2 普通用户，需要使用角色->权限数据
            permissions = jdbcTemplate.queryForList(LoginConstants.QUERY_PERMISSION_SQL, String.class, id);
        }
        if (permissions.isEmpty()) {
            return Collections.emptySet();
        }

        return permissions.stream()
                .distinct() // 去重
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

}
