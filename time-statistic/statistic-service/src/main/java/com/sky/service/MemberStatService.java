package com.sky.service;

import com.sky.dto.*;

/**
 * @author sky
 * @create 2021-12-23 15:10
 */
public interface MemberStatService {

    PieChartDTO pieChart();

    LineChartSimpleDTO lineChartSimple();

    ColumnChartDTO columnChart();

    MixedChartDTO mixChart();

    RewardChartDTO rewardChart();
}
