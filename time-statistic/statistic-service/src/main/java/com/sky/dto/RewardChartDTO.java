package com.sky.dto;

import com.sky.utils.TimeUtils;
import lombok.Data;

/**
 * @author sky
 * @create 2022-01-05 17:12
 */
@Data
public class RewardChartDTO {

    private String[] days;

    private int[] rewards;

    private int[] punishes;

    public RewardChartDTO() {
        this.days = TimeUtils.getDays();
        this.rewards = new int[]{0,0,0,0,0,0,0};
        this.punishes = new int[]{0,0,0,0,0,0,0};
    }
}
