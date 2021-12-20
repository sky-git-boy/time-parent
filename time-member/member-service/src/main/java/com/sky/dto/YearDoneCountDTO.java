package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 一年内完成事项的数量
 * @author sky
 * @create 2021-12-19 15:05
 */
@ApiModel(value = "com-sky-domain-YearDoneCountDTO")
@Data
public class YearDoneCountDTO {

    @ApiModelProperty("完成时间 yyyy-MM-dd")
    private String time;

    @ApiModelProperty("完成数量")
    private String count;

}
