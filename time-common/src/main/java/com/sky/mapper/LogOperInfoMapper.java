package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.LogOperInfo;
import com.sky.dto.DataDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-14 10:50
 */
public interface LogOperInfoMapper extends BaseMapper<LogOperInfo> {
    List<DataDTO> getDataDays();

    int getLoginCount();

    List<DataDTO> getOperDataDays();

    // 获取任务各状态总数
    List<DataDTO> getPieChartDTO(Long userId);

    // 近七日任务数
    List<DataDTO> columnChart(Long userId);

    // 近七日完成趋势
    List<DataDTO> lineChartSimple(Long userId);

    // 获取今年每月的任务数
    List<DataDTO> getTaskCountEachMonth(Long userId);

    // 获取今年每月的自省数
    List<DataDTO> getJournalCountEachMonth(Long userId);

    // 获取今年每月的事件数
    List<DataDTO> getEventCountEachMonth(Long userId);

    // 近七日奖励次数
    List<DataDTO> getRewardCount(Long userId);

    // 近七日惩罚次数
    List<DataDTO> getPunishCount(Long userId);
}