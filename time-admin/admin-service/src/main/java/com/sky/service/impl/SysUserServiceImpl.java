package com.sky.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.SysUserMapper;
import com.sky.domain.SysUser;
import com.sky.service.SysUserService;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
