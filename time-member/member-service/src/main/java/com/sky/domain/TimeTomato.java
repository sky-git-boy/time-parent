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
 * 番茄时钟表
 * @author sky
 * @create 2021-12-03 17:35
 */
@ApiModel(value = "com-sky-domain-TimeTomato")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_tomato")
public class TimeTomato extends BaseEntity {
    /**
     * 番茄时钟ID
     */
    @TableId(value = "tomato_id", type = IdType.INPUT)
    @ApiModelProperty(value = "番茄时钟ID")
    private Long tomatoId;

    /**
     * 番茄时钟名称
     */
    @TableField(value = "tomato_name")
    @ApiModelProperty(value = "番茄时钟名称")
    private String tomatoName;

    /**
     * 用户Id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户Id")
    private Long userId;

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

    /**
     * 持续时间
     */
    @TableField(value = "time")
    @ApiModelProperty(value = "持续时间")
    private int time;

    public static final String COL_TOMATO_ID = "tomato_id";

    public static final String COL_TOMATO_NAME = "tomato_name";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_TIME = "time";
}