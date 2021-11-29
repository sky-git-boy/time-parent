package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    // 查询用户的角色代码
    List<String> getUserRoleCode(Long userId);

    // 根据用户 IDS 删除 sys_role_user 里面的数据
    int deleteRoleUserByUserIds(@Param("ids") List<Long> ids);

    // 根据角色ID删除sys_role_menu的数据
    int deleteRoleMenuByRoleIds(@Param("rids") List<Long> rids);

    // 根据角色ID删除sys_role_user里面的数据
    int deleteRoleUserByRoleIds(@Param("rids") List<Long> rids);

    // 根据用户ID查询用户拥有的角色IDS
    List<Long> getRoleIdsByUserId(Long userId);

    // 保存角色和用户之间的关系
    int saveRoleUser(@Param("userId") Long userId, @Param("roleId") Long roleId, @Param("createBy") Long createBy, @Param("createTime") Date createTime);

    // 根据菜单id删除sys_role_menu里面的数据
    int deleteRoleMenuByMenuIds(@Param("ids") List<Long> ids);

    // 保存角色和菜单之间的关系
    int saveRoleMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId, @Param("createBy") Long createBy, @Param("createTime") Date createTime);
}