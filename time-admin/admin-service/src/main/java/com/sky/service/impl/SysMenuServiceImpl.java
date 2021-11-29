package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sky.constants.Constants;
import com.sky.dto.MenuDTO;
import com.sky.mapper.SysRoleMapper;
import com.sky.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.SysMenuMapper;
import com.sky.domain.SysMenu;
import com.sky.service.SysMenuService;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private SysRoleMapper roleMapper;

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

    @Override
    public List<SysMenu> listAllMenus(MenuDTO menuDto) {
        QueryWrapper<SysMenu> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(menuDto.getMenuName()), SysMenu.COL_MENU_NAME, menuDto.getMenuName());
        qw.eq(StringUtils.isNotBlank(menuDto.getStatus()), SysMenu.COL_STATUS, menuDto.getStatus());
        qw.eq(SysMenu.COL_DEL_FLAG, Constants.DEL_FALSE);
        return this.menuMapper.selectList(qw);
    }

    @Override
    public int addMenu(MenuDTO menuDto) {
        SysMenu menu = new SysMenu();
        BeanUtils.copyProperties(menuDto, menu);
        menu.setCreateBy(menuDto.getSimpleUser().getUserId());
        menu.setCreateTime(new Date());
        return this.menuMapper.insert(menu);
    }

    @Override
    public int updateMenu(MenuDTO menuDto) {
        SysMenu menu = new SysMenu();
        BeanUtils.copyProperties(menuDto, menu);
        menu.setUpdateBy(menuDto.getSimpleUser().getUserId());
        menu.setUpdateTime(new Date());
        return this.menuMapper.updateById(menu);
    }

    @Override
    public SysMenu getOne(Long menuId) {
        return this.menuMapper.selectById(menuId);
    }

    @Override
    public boolean hasChildByMenuId(Long menuId) {
        return this.menuMapper.queryChildCountByMenuId(menuId) > 0L;
    }

    @Override
    @Transactional
    public int deleteMenuById(Long menuId) {
        // 先删除sys_role_menu中间表的数据
        this.roleMapper.deleteRoleMenuByMenuIds(Collections.singletonList(menuId));
        return this.menuMapper.deleteById(menuId);
    }

    @Override
    public List<Long> getMenuIdsByRoleId(Long roleId) {
        return this.menuMapper.queryMenuIdsByRoleId(roleId);
    }

}
