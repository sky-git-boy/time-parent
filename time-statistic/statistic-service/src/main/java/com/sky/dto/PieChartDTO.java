package com.sky.dto;

import lombok.Data;

/**
 * @author sky
 * @create 2021-12-23 15:16
 */
@Data
public class PieChartDTO {

    // 各状态总数
    private int[] statusCount;

    public PieChartDTO() {
        this.statusCount = new int[]{0, 0, 0, 0};
    }
}
