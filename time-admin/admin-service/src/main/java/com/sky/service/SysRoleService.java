package com.sky.service;

import com.sky.domain.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.RoleDTO;
import com.sky.vo.DataGridView;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 是否为超管
     */
    boolean isSuperAdmin(Long userId);

    /**
     * 分页查询角色信息
     */
    DataGridView listUserForPage(RoleDTO roleDto);

    /**
     * 角色详情
     */
    RoleDTO getOne(Long roleId);

    /**
     * 添加角色
     */
    int addRole(RoleDTO roleDto);

    /**
     * 修改角色
     */
    int updateRole(RoleDTO roleDto);

    /**
     * 删除角色
     */
    int deleteRoleByIds(Long[] roleIds);

    /**
     * 查询所有可用角色
     */
    List<SysRole> listAllRoles();

    /**
     * 根据用户ID查询用户拥有的角色IDS
     */
    List<Long> getRoleIdsByUserId(Long userId);

    /**
     * 保存角色和用户之间的关系
     */
    int saveRoleUser(Long userId, Long[] roleIds, Long createBy);
}
