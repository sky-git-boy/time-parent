package com.sky.service;

import com.sky.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.MenuDTO;

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

    /**
     * 查询所有菜单及权限信息
     */
    List<SysMenu> listAllMenus(MenuDTO menuDto);

    /**
     * 添加菜单
     */
    int addMenu(MenuDTO menuDto);

    /**
     * 修改菜单
     */
    int updateMenu(MenuDTO menuDto);

    /**
     * 获取菜单详情
     */
    SysMenu getOne(Long menuId);

    /**
     * 判断当前菜单有没有子节点
     */
    boolean hasChildByMenuId(Long menuId);

    /**
     * 删除菜单
     */
    int deleteMenuById(Long menuId);

    /**
     * 根据角色ID查询已分配菜单ID[只查子节点]
     */
    List<Long> getMenuIdsByRoleId(Long roleId);
}
