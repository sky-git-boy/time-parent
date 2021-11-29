package com.sky.controller;

import com.sky.constants.Constants;
import com.sky.domain.SimpleUser;
import com.sky.domain.SysMenu;
import com.sky.dto.MenuDTO;
import com.sky.exception.BusinessException;
import com.sky.service.SysMenuService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单管理控制器
 *
 * @author sky
 * @create 2021-11-29 14:50
 */
@RestController
@RequestMapping("/menu")
@PreAuthorize("hasAuthority('system_menu')")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    /**
     * 查询菜单下拉树
     */
    @GetMapping("selectMenuTree")
    public R selectMenuTree(){
        MenuDTO menuDto = new MenuDTO();
        menuDto.setStatus(Constants.STATUS_TRUE); // 只查询可用的
        return R.success(this.menuService.listAllMenus(menuDto));
    }

    /**
     * 查询所有菜单及权限信息
     */
    @GetMapping("listAllMenus")
    public R listAllMenus(MenuDTO menuDto) {
        List<SysMenu> list = this.menuService.listAllMenus(menuDto);
        return R.success(list);
    }

    /**
     * 添加菜单
     */
    @PostMapping("addMenu")
    public R addMenu(@RequestBody @Validated MenuDTO menuDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null != user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        menuDto.setSimpleUser(user);
        return R.toAjax(this.menuService.addMenu(menuDto));
    }

    /**
     * 修改菜单
     */
    @PutMapping("updateMenu")
    public R updateMenu(@RequestBody @Validated MenuDTO menuDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null != user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        menuDto.setSimpleUser(user);
        return R.toAjax(this.menuService.updateMenu(menuDto));
    }

    /**
     * 根据菜单ID查询一个
     */
    @GetMapping("getMenuById/{menuId}")
    public R getMenuById(@PathVariable Long menuId) {
        SysMenu menu = this.menuService.getOne(menuId);
        return R.success(menu);
    }

    /**
     * 根据菜单ID删除菜单
     */
    @DeleteMapping("deleteMenuById/{menuId}")
    public R deleteMenuById(@PathVariable Long menuId) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        // 删除之前要判断当前菜单有没有子节点
        if (this.menuService.hasChildByMenuId(menuId)) {
            return R.fail("当前要删除的菜单有子节点，请先删除子节点");
        }
        return R.toAjax(this.menuService.deleteMenuById(menuId));
    }

    /**
     * 根据角色ID查询已分配菜单ID[只查子节点]
     */
    @GetMapping("getMenuIdsByRoleId/{roleId}")
    public R getMenuIdsByRoleId(@PathVariable Long roleId) {
        List<Long> menusId = this.menuService.getMenuIdsByRoleId(roleId);
        return R.success(menusId);
    }

}
