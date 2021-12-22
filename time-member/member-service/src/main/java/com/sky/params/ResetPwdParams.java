package com.sky.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 重置密码参数
 * @author sky
 * @create 2021-12-22 15:50
 */
@Data
public class ResetPwdParams {

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("验证码")
    private String yzm;

    @ApiModelProperty("新密码")
    private String password;

}
