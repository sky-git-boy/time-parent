package com.sky.dto;

import com.sky.utils.TimeUtils;
import lombok.Data;

/**
 * @author sky
 * @create 2021-12-23 11:10
 */
@Data
public class LineChartDTO {

    private String[] days;

    private int[] loginCount;

    private int[] smsCount;

    public LineChartDTO() {
        this.days = TimeUtils.getDays();
        this.loginCount = new int[]{0,0,0,0,0,0,0};
        this.smsCount = new int[]{0,0,0,0,0,0,0};
    }
}
