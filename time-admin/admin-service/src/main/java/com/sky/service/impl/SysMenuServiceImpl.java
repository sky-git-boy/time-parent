package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sky.constants.Constants;
import com.sky.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.SysMenuMapper;
import com.sky.domain.SysMenu;
import com.sky.service.SysMenuService;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> getMenusByUserId(Long userId, List<String> menuTypes) {
        QueryWrapper<SysMenu> qw = new QueryWrapper<>();
        qw.eq(SysMenu.COL_STATUS, Constants.STATUS_TRUE);
        qw.in(SysMenu.COL_MENU_TYPE, Constants.MENU_TYPE_M, Constants.MENU_TYPE_C); //后台菜单
        qw.orderByAsc(SysMenu.COL_PARENT_ID);
        // 1 如果该用户是超级管理员->>拥有所有的菜单
        if(this.sysRoleService.isSuperAdmin(userId)){
            return list() ; // 查询所有
        }

        // 2 如果该用户不是超级管理员->>查询角色->查询菜单
        return this.menuMapper.selectMenusByUserId(userId, menuTypes);
    }
}
