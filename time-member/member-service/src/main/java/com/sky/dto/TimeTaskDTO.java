package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
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
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @NotNull(message = "标题不能为空")
    private String title;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @NotNull(message = "描述不能为空")
    private String description;

    /**
     * 状态（0待办 1进行中 2完成 3已过期）
     */
    @ApiModelProperty(value = "状态（0待办 1进行中 2完成 3已过期）")
    private String status;

    /**
     * 优先级（0无 1低 2中 3高 ）
     */
    @ApiModelProperty(value = "优先级（0否 1是）")
    private String important;

    /**
     * 标签ID
     */
    @ApiModelProperty(value = "标签（0无 1工作 2业务 3个人）")
    private String tags;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
    private Date endTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "查询结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qEndTime;

}