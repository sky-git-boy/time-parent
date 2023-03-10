package com.sky.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 个人日志DTO
 * @author sky
 * @create 2021-12-03 11:51
 */
@ApiModel(value = "com-sky-domain-TimeJournalDTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeJournalDTO extends BaseDTO {
    /**
     *  记录ID
     */
    @ApiModelProperty(value = " 记录ID")
    private Long recordId;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    @NotNull(message = "标题不能为空")
    private String title;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @NotNull(message = "描述不能为空")
    private String description;

}