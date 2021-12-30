package com.sky.job;

import com.sky.constants.Constants;
import com.sky.dto.SysUserRoleDTO;
import com.sky.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 定时扫描角色表
 * 重置超时的会员
 * @author sky
 * @create 2021-12-30 9:16
 */
@Service
public class PlusUserJob {

    @Autowired
    private SysRoleMapper roleMapper;

    // 每天0点扫描待办
    @Scheduled(cron = "0 0 0 * * ?")
    public void plusUserJob() {
        // 待处理列表
        List<SysUserRoleDTO> dealList = new ArrayList<>();

        // 获取超级用户列表
        List<SysUserRoleDTO> userRoleList = roleMapper.getUserRoleList();
        Date now = new Date();
        userRoleList.forEach(item -> {
            // 已过期 -> 过期时间小于当前时间
            if (item.getExpireTime().before(now)) {
                dealList.add(item);
            }
        });

        // 对过期会员进行重置成普通会员
        dealList.forEach(item -> roleMapper.updatePlusUserRole(item.getUserId(), Constants.ROLE_USER_ID, null));
    }
}
