package com.sky.service;

import com.sky.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.RemoteUserDTO;
import com.sky.dto.UserDTO;
import com.sky.vo.DataGridView;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户 ID 查询用户
     *
     * @param userId 用户ID
     */
    SysUser getOne(Long userId);

    /**
     * 分页查询用户信息
     */
    DataGridView listUserForPage(UserDTO userDto);

    /**
     * 添加用户
     */
    int addUser(UserDTO userDto);

    /**
     * 修改用户信息
     */
    int updateUser(UserDTO userDto);

    /**
     * 根据 ID 删除用户信息
     */
    int deleteUserByIds(Long[] userIds);

    /**
     * 重置用户密码
     */
    int resetPwd(Long[] userIds);

    /**
     * 查询所有可用用户信息
     */
    List<SysUser> selectAllUser();

    /**
     * 前台用户修改密码
     */
    int changePwd(RemoteUserDTO dto);

    /**
     * 前台用户注册
     */
    int register(RemoteUserDTO dto);

    /**
     * 会员升级
     */
    int plusUser(Long userId, String orderType);
}
