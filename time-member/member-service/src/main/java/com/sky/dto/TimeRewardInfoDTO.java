package com.sky.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sky.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户奖惩记录
 * @author sky
 * @create 2022-01-03 11:05
 */
@ApiModel(value = "com-sky-domain-TimeRewardInfoDTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TimeRewardInfoDTO extends BaseDTO {
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

}