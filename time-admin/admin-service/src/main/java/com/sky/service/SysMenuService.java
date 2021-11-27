package com.sky.service;

import com.sky.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取用户菜单
     */
    List<SysMenu> getMenusByUserId(Long userId, List<String> menuTypes);
}
