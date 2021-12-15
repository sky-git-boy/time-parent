package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 任务表
 * @author sky
 * @create 2021-12-15 11:11
 */
@ApiModel(value = "com-sky-domain-TimeTaskDTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TimeTaskDTO extends BaseDTO {

    /**
     * 任务ID
     */
    @ApiModelProperty(value = "任务ID")
    private Long taskId;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 状态（0待办 1进行中 2完成 3已过期）
     */
    @ApiModelProperty(value = "状态（0待办 1进行中 2完成 3已过期）")
    private String status;

    /**
     * 优先级（0无 1低 2中 3高 ）
     */
    @ApiModelProperty(value = "优先级（0无 1低 2中 3高 ）")
    private String important;

    /**
     * 标签ID
     */
    @ApiModelProperty(value = "标签ID")
    private Long tagId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

}