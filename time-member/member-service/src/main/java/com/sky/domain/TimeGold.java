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
    @TableField(value = "data_json")
    @ApiModelProperty(value = "目标内容json格式")
    private String dataJson;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 开始时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public static final String COL_GOLD_ID = "gold_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_CREATE_TIME = "create_time";

}