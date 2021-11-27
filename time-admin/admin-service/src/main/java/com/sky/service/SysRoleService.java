package com.sky.service;

import com.sky.domain.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 是否为超管
     */
    boolean isSuperAdmin(Long userId);
}
