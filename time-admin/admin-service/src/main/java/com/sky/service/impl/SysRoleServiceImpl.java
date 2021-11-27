package com.sky.service.impl;

import com.sky.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.SysRoleMapper;
import com.sky.domain.SysRole;
import com.sky.service.SysRoleService;
import org.springframework.util.StringUtils;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public boolean isSuperAdmin(Long userId) {
        List<String> roleCode = this.roleMapper.getUserRoleCode(userId);
        return !StringUtils.isEmpty(roleCode) && roleCode.contains(Constants.ROLE_ADMIN);
    }
}
