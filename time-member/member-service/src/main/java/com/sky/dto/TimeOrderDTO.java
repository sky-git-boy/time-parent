package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sky
 * @create 2021-12-29 16:39
 */
@ApiModel(value = "com-sky-domain-TimeOrderDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeOrderDTO {

    /**
     * 费用
     */
    @ApiModelProperty(value = "费用")
    private BigDecimal orderAmount;

    /**
     * 订单状态0未支付  1 支付成功  2支付超时 3支付失败
     */
    @ApiModelProperty(value = "订单状态0未支付  1 支付成功  2支付超时 3支付失败")
    private String orderStatus;

    /**
     *  订单项目 0一个月 1半年 2一年 3永久
     */
    @ApiModelProperty(value = " 订单项目 0一个月 1半年 2一年 3永久")
    private String orderItem;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

}
