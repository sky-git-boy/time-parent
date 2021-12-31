package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.TimeTask;
import com.sky.dto.YearDoneCountDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-15 11:11
 */
public interface TimeTaskMapper extends BaseMapper<TimeTask> {
    // 一年完成数
    List<YearDoneCountDTO> doneCunt(Long userId);

    // 获取用户今日完成数
    int getUserTodayDoneCount(Long userId);
}