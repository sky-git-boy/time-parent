package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 消息对象
 * @author sky
 * @create 2021-12-31 21:41
 */
@Data
@AllArgsConstructor
public class MessageDTO {

    @ApiModelProperty("消息主体")
    private String content;

    @ApiModelProperty("消息类型（0奖励 1惩罚）")
    private String type;
}
