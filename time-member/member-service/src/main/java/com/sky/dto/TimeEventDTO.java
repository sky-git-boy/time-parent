package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author sky
 * @create 2021-12-21 15:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeEventDTO extends BaseDTO {
    /**
     * 事件主键
     */
    @ApiModelProperty(value = "事件主键")
    private Long id;

    /**
     * 事件标题
     */
    @ApiModelProperty(value = "事件标题")
    private String title;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间（yyyy-MM-dd）")
    private Date startDate;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间（yyyy-MM-dd）")
    private Date endDate;

    /**
     * 标签（0无 1工作 2业务 3个人）
     */
    @ApiModelProperty(value = "标签（0无 1工作 2业务 3个人）")
    private String tags;

    @ApiModelProperty(value = "用法")
    private String classes;

}