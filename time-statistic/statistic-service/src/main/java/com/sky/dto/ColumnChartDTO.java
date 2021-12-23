package com.sky.dto;

import com.sky.utils.TimeUtils;
import lombok.Data;

/**
 * @author sky
 * @create 2021-12-23 15:16
 */
@Data
public class ColumnChartDTO {

    private String[] days;

    private int[] count;

    public ColumnChartDTO() {
        this.days = TimeUtils.getDays();
        this.count = new int[]{0,0,0,0,0,0,0};
    }
}
