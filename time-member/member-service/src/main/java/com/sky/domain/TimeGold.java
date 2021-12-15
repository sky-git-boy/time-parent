package com.sky.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 个人目标表
 * @author sky
 * @create 2021-12-15 10:32
 */
@ApiModel(value = "com-sky-domain-TimeGold")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_gold")
public class TimeGold extends BaseEntity {
    /**
     * 目标ID
     */
    @TableId(value = "gold_id", type = IdType.INPUT)
    @ApiModelProperty(value = "目标ID")
    private Long goldId;

    /**
     * 目标内容
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "目标内容")
    private String description;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 状态（0 todo 1 doing 2 done）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态（0 todo 1 doing 2 done）")
    private String status;

    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    public static final String COL_GOLD_ID = "gold_id";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_STATUS = "status";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";
}