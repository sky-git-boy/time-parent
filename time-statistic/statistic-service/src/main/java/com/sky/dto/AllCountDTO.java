package com.sky.dto;

import lombok.Data;

/**
 * 各内容总数
 * @author sky
 * @create 2021-12-23 11:32
 */
@Data
public class AllCountDTO {

    // 用户登录总数
    private Long userLoginCount;

    // 消息发送总数
    private Long smsCount;

    // 任务总数
    private Long taskCount;

    // 用户总数
    private Long userCount;

    // 自省总数
    private Long journalCount;

    // 事件总数
    private Long evenCount;

    // 白噪音总数
    private Long musicCount;

    // 公告总数
    private Long noticeCount;

    // 轮播图数量
    private Long slideCount;

    public AllCountDTO() {
        this.userLoginCount = 0L;
        this.smsCount = 0L;
        this.taskCount = 0L;
        this.userCount = 0L;
        this.journalCount = 0L;
        this.evenCount = 0L;
        this.musicCount = 0L;
        this.noticeCount = 0L;
        this.slideCount = 0L;
    }
}
