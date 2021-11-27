package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.SysRole;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    // 查询用户的角色代码
    List<String> getUserRoleCode(Long userId);
}