package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单统计DTO
 * @author sky
 * @create 2021-12-29 21:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatDTO {
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("值")
    private int value;
}
