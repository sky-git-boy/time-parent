package com.sky.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户奖惩配置表
 * @author sky
 * @create 2021-12-30 14:07
 */
@ApiModel(value = "com-sky-domain-TimeRulesDTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeRulesDTO extends BaseDTO {

    /**
     * 奖惩id
     */
    @ApiModelProperty(value = "奖惩id")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 需完成任务数
     */
    @ApiModelProperty(value = "需完成任务数")
    private String needCount;

    /**
     * 奖励内容
     */
    @ApiModelProperty(value = "奖励内容")
    private String rewardContent;

    /**
     * 惩罚内容
     */
    @ApiModelProperty(value = "惩罚内容")
    private String punishmentContent;

    /**
     * 状态（0启用 1禁用）
     */
    @ApiModelProperty(value = "状态（0启用 1禁用）")
    private String status;

}