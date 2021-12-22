package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author sky
 * @create 2021-12-21 10:36
 */
@Data
public class OperLogDTO {

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("操作类型")
    private String businessType;

    @ApiModelProperty("操作时间")
    private Date operTime;
}
