package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @create 2021-11-29 11:47
 */
@ApiModel(value = "com-sky-dto-RoleDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleDTO extends BaseDTO {

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色权限编码
     */
    @ApiModelProperty(value = "角色权限编码")
    @NotBlank(message = "角色权限编码不能为空")
    private String roleCode;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    @NotNull(message = "角色显示顺序不能为空")
    private Integer roleSort;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 角色状态（0正常 1停用）
     */
    @NotBlank(message = "角色状态不能为空")
    @ApiModelProperty(value = "角色状态（0正常 1停用）")
    private String status;

}
