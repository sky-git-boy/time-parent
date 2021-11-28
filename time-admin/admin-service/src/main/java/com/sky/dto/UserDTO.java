package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author sky
 * @create 2021-11-28 15:04
 */
@ApiModel(value = "com-sky-dto-UserDto")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 用户名
     */
    @NotBlank(message = "用户类型不能为空")
    @ApiModelProperty(value = "用户类型（0后台用户 1前台用户）")
    private String userType;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String picture;

    /**
     * 电话
     */
    @NotBlank(message = "用户电话不能为空")
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    /**
     * 帐号状态（0正常 1停用）
     */
    @NotBlank(message = "帐号状态不能为空")
    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    private String status;

}
