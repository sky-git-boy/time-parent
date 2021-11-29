package com.sky.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.constants.Constants;
import com.sky.dto.RoleDTO;
import com.sky.vo.DataGridView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.SysRoleMapper;
import com.sky.domain.SysRole;
import com.sky.service.SysRoleService;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    public DataGridView listUserForPage(RoleDTO roleDto) {
        Page<SysRole> page = new Page<>(roleDto.getPageNum(), roleDto.getPageSize());
        QueryWrapper<SysRole> qw = new QueryWrapper<>();
        qw.like(!StringUtils.isEmpty(roleDto.getRoleName()), SysRole.COL_ROLE_NAME, roleDto.getRoleName());
        qw.like(!StringUtils.isEmpty(roleDto.getRoleCode()), SysRole.COL_ROLE_CODE, roleDto.getRoleCode());
        qw.eq(!StringUtils.isEmpty(roleDto.getStatus()), SysRole.COL_STATUS, roleDto.getStatus());
        qw.ge(roleDto.getBeginTime() != null, SysRole.COL_CREATE_TIME, roleDto.getBeginTime());
        qw.le(roleDto.getEndTime() != null, SysRole.COL_CREATE_TIME, roleDto.getEndTime());
        qw.eq(SysRole.COL_DEL_FLAG, Constants.DEL_FALSE);
        qw.orderByAsc(SysRole.COL_ROLE_SORT);
        this.roleMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public RoleDTO getOne(Long roleId) {
        RoleDTO dto = new RoleDTO();
        SysRole role = this.roleMapper.selectById(roleId);
        BeanUtils.copyProperties(role, dto);
        return dto;
    }

    @Override
    public int addRole(RoleDTO roleDto) {
        SysRole role = new SysRole();
        BeanUtils.copyProperties(roleDto, role);
        role.setCreateBy(roleDto.getSimpleUser().getUserId());
        role.setCreateTime(new Date());
        return this.roleMapper.insert(role);
    }

    @Override
    public int updateRole(RoleDTO roleDto) {
        SysRole role = new SysRole();
        BeanUtil.copyProperties(roleDto, role);
        //设置修改人
        role.setUpdateBy(roleDto.getSimpleUser().getUserId());
        role.setUpdateTime(new Date());
        return this.roleMapper.updateById(role);
    }

    @Override
    @Transactional
    public int deleteRoleByIds(Long[] roleIds) {
        if (roleIds != null && roleIds.length > 0) {
            List<Long> rids = Arrays.asList(roleIds);
            //根据角色ID删除sys_role_menu的数据
            this.roleMapper.deleteRoleMenuByRoleIds(rids);
            //根据角色ID删除sys_role_user里面的数据
            this.roleMapper.deleteRoleUserByRoleIds(rids);
            //删除角色
            return this.roleMapper.deleteBatchIds(rids);
        } else
            return 0;
    }

    @Override
    public List<SysRole> listAllRoles() {
        QueryWrapper<SysRole> qw = new QueryWrapper<>();
        qw.eq(SysRole.COL_STATUS, Constants.STATUS_TRUE);
        qw.eq(SysRole.COL_DEL_FLAG, Constants.DEL_FALSE);
        qw.orderByAsc(SysRole.COL_ROLE_SORT);
        return this.roleMapper.selectList(qw);
    }

    @Override
    public List<Long> getRoleIdsByUserId(Long userId) {
        return this.roleMapper.getRoleIdsByUserId(userId);
    }

    @Override
    @Transactional
    public int saveRoleUser(Long userId, Long[] roleIds, Long createBy) {
        try {
            // 根据用户 ID 先删除 sys_role_menu 里面原来的数据
            this.roleMapper.deleteRoleUserByUserIds(Collections.singletonList(userId));
            Date date = new Date();
            for (Long roleId : roleIds) {
                this.roleMapper.saveRoleUser(userId, roleId, createBy, date);
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    @Transactional
    public int saveRoleMenu(Long roleId, Long[] menuIds, Long userId) {
        try {
            // 根据角色ID先删除sys_role_menu里面原来的数据
            this.roleMapper.deleteRoleMenuByRoleIds(Collections.singletonList(roleId));
            for (Long menuId : menuIds) {
                int i = this.roleMapper.saveRoleMenu(roleId, menuId, userId, new Date());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


}
