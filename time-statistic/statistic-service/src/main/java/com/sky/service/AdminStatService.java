package com.sky.service;

import com.sky.dto.AllCountDTO;
import com.sky.dto.LineChartDTO;

/**
 * @author sky
 * @create 2021-12-23 10:26
 */
public interface AdminStatService {

    LineChartDTO lineChart();

    AllCountDTO getAllCount();
}
