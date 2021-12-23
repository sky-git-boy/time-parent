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
    private int userLoginCount;

    // 消息发送总数
    private int smsCount;

    // 总操作数
    private int operCount;

    // 任务总数
    private int taskCount;

    // 用户总数
    private int userCount;

    // 自省总数
    private int journalCount;

    // 事件总数
    private int evenCount;

    // 白噪音总数
    private int musicCount;

    // 公告总数
    private int noticeCount;

    // 轮播图数量
    private int slideCount;

    public AllCountDTO() {
        this.userLoginCount = 0;
        this.smsCount = 0;
        this.taskCount = 0;
        this.operCount = 0;
        this.userCount = 0;
        this.journalCount = 0;
        this.evenCount = 0;
        this.musicCount = 0;
        this.noticeCount = 0;
        this.slideCount = 0;
    }
}
