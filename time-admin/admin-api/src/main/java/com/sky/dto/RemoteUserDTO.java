package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sky
 * @create 2021-12-22 16:27
 */
@Data
@ApiModel(value = "用户的参数")
public class RemoteUserDTO {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("手机号")
    private String phone;

}
