package com.sky.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 任务表
 * @author sky
 * @create 2021-12-15 11:11
 */
@ApiModel(value = "com-sky-domain-TimeTask")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_task")
public class TimeTask extends BaseEntity {
    /**
     * 任务ID
     */
    @TableId(value = "task_id", type = IdType.INPUT)
    @ApiModelProperty(value = "任务ID")
    private Long taskId;

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 状态（0待办 1进行中 2完成 3已过期）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态（0待办 1进行中 2完成 3已过期）")
    private String status;

    /**
     * 优先级（0无 1低 2中 3高 ）
     */
    @TableField(value = "important")
    @ApiModelProperty(value = "优先级（0否 1是 ）")
    private String important;

    /**
     * 标签ID
     */
    @TableField(value = "tags")
    @ApiModelProperty(value = "标签（0无 1工作 2业务 3个人）")
    private String tags;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 完成时间
     */
    @TableField(value = "done_time", updateStrategy = FieldStrategy.IGNORED)
    @ApiModelProperty(value = "完成时间")
    private String doneTime;

    public static final String COL_TASK_ID = "task_id";

    public static final String COL_TITLE = "title";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_STATUS = "status";

    public static final String COL_IMPORTANT = "important";

    public static final String COL_TAG_ID = "tag_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_DONE_TIME = "done_time";
}