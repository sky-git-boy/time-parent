package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 个人目标表
 * @author sky
 * @create 2021-12-15 10:32
 */
@ApiModel(value = "com-sky-domain-TimeGoldDTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TimeGoldDTO extends BaseDTO {
    /**
     * 目标ID
     */
    @ApiModelProperty(value = "目标ID")
    private Long goldId;

    /**
     * 目标内容
     */
    @ApiModelProperty(value = "目标内容")
    private String dataJson;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date createTime;

}