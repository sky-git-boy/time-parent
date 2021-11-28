package com.sky.dto;

import com.sky.domain.SysMenu;
import com.sky.vo.MenuTreeVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

/**
 * 登录的返回值
 *
 * @author sky
 * @create 2021-11-21 16:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResultDTO {

    /**
     * 登录产生的token
     */
    private String token;
    /**
     * 前端的菜单数据
     */
    private List<MenuTreeVo> menus;
    /**
     * 权限数据
     */
    private List<SimpleGrantedAuthority> authorities;

}
