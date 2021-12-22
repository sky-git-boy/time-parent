package com.sky.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.constants.Constants;
import com.sky.dto.RemoteUserDTO;
import com.sky.dto.UserDTO;
import com.sky.mapper.SysRoleMapper;
import com.sky.utils.IdGeneratorSnowflake;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.SysUserMapper;
import com.sky.domain.SysUser;
import com.sky.service.SysUserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public SysUser getOne(Long userId) {
        return this.userMapper.selectById(userId);
    }

    @Override
    public DataGridView listUserForPage(UserDTO userDto) {
        Page<SysUser> page = new Page<>(userDto.getPageNum(), userDto.getPageSize());
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(userDto.getUserName()), SysUser.COL_USER_NAME, userDto.getUserName());
        qw.like(StringUtils.isNotBlank(userDto.getPhone()), SysUser.COL_PHONE, userDto.getPhone());
        qw.eq(StringUtils.isNotBlank(userDto.getStatus()), SysUser.COL_STATUS, userDto.getStatus());
        qw.eq(StringUtils.isNotBlank(userDto.getUserType()), SysUser.COL_USER_TYPE, userDto.getUserType());
        qw.ge(null!= userDto.getBeginTime(), SysUser.COL_CREATE_TIME, userDto.getBeginTime());
        qw.le(null!= userDto.getEndTime(), SysUser.COL_CREATE_TIME, userDto.getEndTime());
        qw.orderByAsc(SysUser.COL_USER_ID); this.userMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int addUser(UserDTO userDto) {
        SysUser user = new SysUser();
        BeanUtil.copyProperties(userDto,user);
        user.setUserType(Constants.USER_NORMAL);
        // 设置密码（默认手机号后5位）
        String defaultPwd = user.getPhone().substring(5);
        user.setCreateBy(userDto.getSimpleUser().getUserId());
        user.setCreateTime(DateUtil.date());
        user.setPicture(Constants.DEFAULT_PICTURE);
        // BCryptPasswordEncoder 对密码进行加密
        user.setPassword(new BCryptPasswordEncoder().encode(defaultPwd));
        return this.userMapper.insert(user);
    }

    @Override
    public int updateUser(UserDTO userDto) {
        SysUser user = this.userMapper.selectById(userDto.getUserId());
        if(null == user)
            return 0;
        BeanUtil.copyProperties(userDto,user);
        user.setUpdateBy(userDto.getSimpleUser().getUserId());
        return this.userMapper.updateById(user);
    }

    @Override
    public int deleteUserByIds(Long[] userIds) {
        List<Long> ids = Arrays.asList(userIds);
        //根据用户 IDS 删除 sys_role_user 里面的数据
        this.roleMapper.deleteRoleUserByUserIds(ids);
        return this.userMapper.deleteBatchIds(ids);
    }

    @Override
    public int resetPwd(Long[] userIds) {
        int res = 0;

        for(Long userId : userIds) {
            SysUser user = this.userMapper.selectById(userId);
            String defaultPwd;
            if(user.getUserType().equals(Constants.USER_ADMIN)) {
                defaultPwd = "123456";
            } else {
                defaultPwd = user.getPhone().substring(5);
            }
            user.setPassword(new BCryptPasswordEncoder().encode(defaultPwd));
            res += this.userMapper.updateById(user);
        }

        return res == userIds.length ? 1 : 0;
    }

    @Override
    public List<SysUser> selectAllUser() {
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq(SysUser.COL_STATUS, Constants.STATUS_TRUE);
        qw.eq(SysUser.COL_USER_TYPE, Constants.USER_NORMAL);
        qw.orderByAsc(SysUser.COL_USER_ID);
        return this.userMapper.selectList(qw);
    }

    @Override
    public int changePwd(RemoteUserDTO dto) {
        SysUser user = this.userMapper.selectById(dto.getUserId());
        // 判断是否为前台用户
        if (user.getUserType().equals(Constants.USER_NORMAL)) {
            user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        }
        return this.userMapper.updateById(user);
    }

    @Override
    public int register(RemoteUserDTO dto) {
        SysUser user = new SysUser();
        user.setUserType(Constants.USER_NORMAL);
        user.setDelFlag(Constants.DEL_FALSE);
        user.setStatus(Constants.STATUS_TRUE);
        user.setPicture(Constants.DEFAULT_PICTURE);
        user.setCreateTime(new Date());

        user.setUserId(IdGeneratorSnowflake.snowflakeId());

        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        user.setUserName(dto.getUserName());

        try {
            // 添加用户
            this.userMapper.insert(user);
            // 设置用户权限
            return this.roleMapper.saveRoleUser(user.getUserId(), Constants.ROLE_USER_ID, null, new Date());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
