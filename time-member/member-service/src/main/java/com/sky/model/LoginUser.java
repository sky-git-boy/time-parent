package com.sky.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sky
 * @create 2021-12-01 17:33
 */
@ApiModel(value = "登录成功的用户")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "token的过期时间")
    private Long expire;

    @ApiModelProperty(value = "access_token")
    private String access_token;

    @ApiModelProperty(value = "refreshToken")
    private String refresh_token;

}
