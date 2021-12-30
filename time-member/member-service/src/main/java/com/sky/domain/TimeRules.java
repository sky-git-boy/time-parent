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
 * 用户奖惩配置表
 * @author sky
 * @create 2021-12-30 14:07
 */
@ApiModel(value = "com-sky-domain-TimeRules")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_rules")
public class TimeRules extends BaseEntity {
    /**
     * 奖惩id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "奖惩id")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 需完成任务数
     */
    @TableField(value = "need_count")
    @ApiModelProperty(value = "需完成任务数")
    private String needCount;

    /**
     * 奖励内容
     */
    @TableField(value = "reward_content")
    @ApiModelProperty(value = "奖励内容")
    private String rewardContent;

    /**
     * 惩罚内容
     */
    @TableField(value = "punishment_content")
    @ApiModelProperty(value = "惩罚内容")
    private String punishmentContent;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 状态（0启用 1禁用）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态（0启用 1禁用）")
    private String status;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_NEED_COUNT = "need_count";

    public static final String COL_REWARD_CONTENT = "reward_content";

    public static final String COL_PUNISHMENT_CONTENT = "punishment_content";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_STATUS = "status";
}