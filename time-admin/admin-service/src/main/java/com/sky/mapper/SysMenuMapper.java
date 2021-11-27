package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-21 16:32
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    // 查询用户拥有的菜单
    List<SysMenu> selectMenusByUserId(
            @Param("userId") Long userId, // 用户Id
            @Param("menuTypes") List<String> menuTypes    // 菜单类型
    );
}