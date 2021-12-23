package com.sky.dto;

import com.sky.utils.TimeUtils;
import lombok.Data;

/**
 * @author sky
 * @create 2021-12-23 15:16
 */
@Data
public class MixedChartDTO {

    private String[] months;

    // 每月任务数
    private int[] taskCountM;

    // 每月事件数
    private int[] eventCountM;

    // 每月反省数
    private int[] journalCountM;

    public MixedChartDTO() {
        this.months = TimeUtils.getMonths();
        this.taskCountM = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        this.eventCountM = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        this.journalCountM = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
    }
}
