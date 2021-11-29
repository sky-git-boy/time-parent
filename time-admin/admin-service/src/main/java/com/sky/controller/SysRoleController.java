package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.dto.RoleDTO;
import com.sky.exception.BusinessException;
import com.sky.service.SysRoleService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 角色管理控制器
 *
 * @author sky
 * @create 2021-11-29 11:42
 */
@RestController
@RequestMapping("/role")
@PreAuthorize("hasAuthority('system_role')")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    /**
     * 分页查询
     */
    @GetMapping("listRoleForPage")
    public R listUserByPage(RoleDTO roleDto) {
        DataGridView view = this.roleService.listUserForPage(roleDto);
        return R.success("查询成功", view.getData(), view.getTotal());
    }

    /**
     * 角色详情
     */
    @GetMapping("getRoleById/{roleId}")
    public R getOne(@PathVariable @Validated @NotNull(message = "角色ID不能为空") Long roleId) {
        return R.success(this.roleService.getOne(roleId));
    }

    /**
     * 添加
     */
    @PostMapping("addRole")
    public R addRole(@RequestBody @Validated RoleDTO roleDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        roleDto.setSimpleUser(user);
        return R.toAjax(this.roleService.addRole(roleDto));
    }

    /**
     * 修改
     */
    @PutMapping("updateRole")
    public R updateRole(@RequestBody @Validated RoleDTO roleDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        roleDto.setSimpleUser(user);
        return R.toAjax(this.roleService.updateRole(roleDto));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteRoleByIds/{roleIds}")
    public R deleteRoleByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] roleIds) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.roleService.deleteRoleByIds(roleIds));
    }

    /**
     * 查询所有可用的角色
     */
    @GetMapping("selectAllRole")
    public R selectAllRole() {
        return R.success(this.roleService.listAllRoles());
    }

    /**
     * 根据用户ID查询用户拥有的角色IDS
     */
    @GetMapping("getRoleIdsByUserId/{userId}")
    public R getRoleIdsByUserId(@PathVariable Long userId) {
        List<Long> roleIds = this.roleService.getRoleIdsByUserId(userId);
        return R.success(roleIds);
    }

    /**
     * 保存角色和用户之间的关系
     */
    @PostMapping("saveRoleUser/{userId}/{roleIds}")
    public R saveRoleUser(@PathVariable Long userId, @PathVariable Long[] roleIds) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }

        /*
         * 因为我们用的路径参数，前端可能传过来的roleIds是一个空的，但是为空的话无法匹配上面的路径
         * 所以如果为空，我们让前端传一个-1过来，如果是-1说明当前角色一个权限也没有选择
         */
        if (roleIds.length == 1 && roleIds[0].equals(-1L)) {
            roleIds = new Long[]{};
        }

        return R.toAjax(this.roleService.saveRoleUser(userId, roleIds, user.getUserId()));
    }

    /**
     * 保存角色和菜单权限关系
     */
    @PostMapping("saveRoleMenu/{roleId}/{menuIds}")
    public R saveRoleMenu(@PathVariable Long roleId, @PathVariable Long[] menuIds) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }

        /*
         * 因为我们用的路径参数，前端可能传过来的roleIds是一个空的，但是为空的话无法匹配上面的路径
         * 所以如果为空，我们让前端传一个-1过来，如果是-1说明当前角色一个权限也没有选择
         */
        if (menuIds.length == 1 && menuIds[0].equals(-1L)) {
            menuIds = new Long[]{};
        }
        return R.toAjax(this.roleService.saveRoleMenu(roleId, menuIds, user.getUserId()));
    }
}
