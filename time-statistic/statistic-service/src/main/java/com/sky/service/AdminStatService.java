package com.sky.service;

import com.sky.dto.AllCountDTO;
import com.sky.dto.BaseDTO;
import com.sky.dto.LineChartDTO;
import com.sky.dto.OrderStatDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-23 10:26
 */
public interface AdminStatService {

    LineChartDTO lineChart();

    AllCountDTO getAllCount();

    AllCountDTO pieChart();

    AllCountDTO systemChart();

    LineChartDTO barChart();

    // 订单状态统计
    List<OrderStatDTO> orderStatusChart(BaseDTO dto);

    // 订单类型统计
    List<OrderStatDTO> orderTypeChart(BaseDTO dto);

    int orderCount(BaseDTO dto);
}
