package com.sky.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.aspectj.annotation.Log;
import com.sky.aspectj.enums.BusinessType;
import com.sky.domain.SimpleUser;
import com.sky.domain.SysUser;
import com.sky.dto.RemoteUserDTO;
import com.sky.dto.UserDTO;
import com.sky.exception.BusinessException;
import com.sky.feign.UserServiceFeign;
import com.sky.service.SysUserService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 用户管理控制器
 *
 * @author sky
 * @create 2021-11-28 10:42
 */
@RestController
@RequestMapping("/user")
public class SysUserController implements UserServiceFeign {
    @Autowired
    private SysUserService userService;

    /**
     * 分页查询
     */
    @GetMapping("listUserForPage")
    @PreAuthorize("hasAuthority('system_user')")
    public R listUserForPage(UserDTO userDto) {
        DataGridView gridView = this.userService.listUserForPage(userDto);
        return R.success("查询成功", gridView.getData(), gridView.getTotal());
    }

    /**
     * 添加
     */
    @PostMapping("addUser")
    @Log(title = "添加角色", businessType = BusinessType.INSERT)
    @PreAuthorize("hasAuthority('system_user')")
    public R addUser(@RequestBody @Validated UserDTO userDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        userDto.setSimpleUser(user);
        return R.toAjax(this.userService.addUser(userDto));
    }

    /**
     * 修改
     */
    @PutMapping("updateUser")
    @Log(title = "修改角色", businessType = BusinessType.UPDATE)
    @PreAuthorize("hasAuthority('system_user')")
    public R updateUser(@RequestBody @Validated UserDTO userDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        userDto.setSimpleUser(user);
        return R.toAjax(this.userService.updateUser(userDto));
    }

    /**
     * 根据ID查询一个用户信息
     */
    @GetMapping("getUserById/{userId}")
    @PreAuthorize("hasAuthority('system_user')")
    public R getUserById(@PathVariable @Validated @NotNull(message = "用户ID不能为空") Long userId) {
        return R.success(this.userService.getOne(userId));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteUserByIds/{userIds}")
    @Log(title = "删除角色", businessType = BusinessType.DELETE)
    @PreAuthorize("hasAuthority('system_user')")
    public R deleteUserByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] userIds) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.userService.deleteUserByIds(userIds));
    }

    /**
     * 查询所有可用的用户
     */
    @GetMapping("selectAllUser")
    @PreAuthorize("hasAuthority('system_user')")
    public R selectAllUser() {
        return R.success(this.userService.selectAllUser());
    }

    /**
     * 重置密码
     */
    @PutMapping("resetPwd/{userIds}")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PreAuthorize("hasAuthority('system_user')")
    public R resetPwd(@PathVariable Long[] userIds) {
        SimpleUser user = SecurityUtils.getUser();
        if (user.getUserId() == null) {
            throw new BusinessException("获取用户信息失败");
        }

        if (userIds.length > 0) {
            return R.toAjax(this.userService.resetPwd(userIds));
        }
        return R.fail("重置失败,没有选择用户");
    }


    // 前台通过用户手机号查询用户
    @Override
    public RemoteUserDTO getUserByPhone(String phone) {
        // 获取用户
        SysUser user = this.userService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getPhone, phone));

        if (null == user) {
            return null;
        }

        // 返回对象
        RemoteUserDTO dto = new RemoteUserDTO();
        dto.setUserId(user.getUserId());
        dto.setPhone(user.getPhone());

        return dto;
    }

    @Override
    public int resetPwd(RemoteUserDTO dto) {
        return this.userService.changePwd(dto);
    }

    @Override
    public int register(RemoteUserDTO dto) {
        SysUser user = this.userService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getPhone, dto.getPhone()));
        if (null != user) {
            return -1;
        }

        return this.userService.register(dto);
    }
}
