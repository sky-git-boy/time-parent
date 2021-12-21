package com.sky.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author sky
 * @create 2021-12-21 15:18
 */
@ApiModel(value = "com-sky-domain-TimeEvent")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_event")
public class TimeEvent extends BaseEntity {
    /**
     * 事件主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "事件主键")
    private Long id;

    /**
     * 事件标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "事件标题")
    private String title;

    /**
     * 开始时间（yyyy-MM-dd）
     */
    @TableField(value = "start_date")
    @ApiModelProperty(value = "开始时间")
    private Date startDate;

    /**
     * 结束时间（yyyy-MM-dd）
     */
    @TableField(value = "end_date")
    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    /**
     * 用户主键
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户主键")
    private Long userId;

    /**
     * 标签（0无 1工作 2业务 3个人）
     */
    @TableField(value = "tags")
    @ApiModelProperty(value = "标签（0无 1工作 2业务 3个人）")
    private String tags;

    @TableField(value = "classes")
    @ApiModelProperty(value = "样式")
    private String classes;

    public static final String COL_EVENT_ID = "event_id";

    public static final String COL_TITLE = "title";

    public static final String COL_START_TIME = "start_date";

    public static final String COL_END_TIME = "end_date";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_TAGS = "tags";

    public static final String COL_CLASSES = "classes";
}