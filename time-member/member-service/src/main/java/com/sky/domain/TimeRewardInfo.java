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
 * 用户奖惩记录
 * @author sky
 * @create 2022-01-03 11:05
 */
@ApiModel(value = "com-sky-domain-TimeRewardInfo")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_reward_info")
public class TimeRewardInfo extends BaseEntity {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 奖惩内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "奖惩内容")
    private String content;

    /**
     * 奖惩内容（0奖励 1惩罚）
     */
    @TableField(value = "type")
    @ApiModelProperty(value = "奖惩内容（0奖励 1惩罚）")
    private String type;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 奖惩时间
     */
    @TableField(value = "creat_time")
    @ApiModelProperty(value = "奖惩时间")
    private Date creatTime;

    public static final String COL_ID = "id";

    public static final String COL_CONTENT = "content";

    public static final String COL_TYPE = "type";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_CREAT_TIME = "creat_time";
}