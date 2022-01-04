package com.sky.dto;

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
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 奖惩内容
     */
    @ApiModelProperty(value = "奖惩内容")
    private String content;

    /**
     * 奖惩内容（0奖励 1惩罚）
     */
    @ApiModelProperty(value = "奖惩内容（0奖励 1惩罚）")
    private String type;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 奖惩时间
     */
    @ApiModelProperty(value = "奖惩时间")
    private Date createTime;

}