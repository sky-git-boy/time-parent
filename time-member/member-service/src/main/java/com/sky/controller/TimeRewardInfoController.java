package com.sky.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.domain.SimpleUser;
import com.sky.domain.TimeRewardInfo;
import com.sky.dto.TimeRewardInfoDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeRewardInfoService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户奖惩记录控制器
 * @author sky
 * @create 2022-01-03 11:07
 */
@RestController
@Api("用户奖惩记录控制器")
@RequestMapping("reward")
public class TimeRewardInfoController {

    @Autowired
    private TimeRewardInfoService rewardInfoService;


    @GetMapping("/list")
    @ApiModelProperty("获取用户奖惩记录")
    public R getRewardInfoList(TimeRewardInfoDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息异常");
        }
        List<TimeRewardInfo> res = this.rewardInfoService.list(
                new LambdaQueryWrapper<TimeRewardInfo>()
                        .eq(TimeRewardInfo::getUserId, dto.getUserId())
                        .eq(TimeRewardInfo::getType, dto.getType())
                        .le(TimeRewardInfo::getCreateTime, dto.getBeginTime())
                        .ge(TimeRewardInfo::getCreateTime, dto.getEndTime())
        );
        return R.success(res);
    }

}
