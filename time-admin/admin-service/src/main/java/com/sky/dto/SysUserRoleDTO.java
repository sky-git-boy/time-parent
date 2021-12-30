package com.sky.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户角色信息表
 * @author sky
 * @create 2021-11-21 16:32
 */
@ApiModel(value = "com-sky-domain-SysUserRoleDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRoleDTO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    /**
     * 过期时间
     */
    @ApiModelProperty(value = "过期时间")
    private Date expireTime;

}