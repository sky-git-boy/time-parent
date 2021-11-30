package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author sky
 * @create 2021-11-29 14:56
 */
@ApiModel(value = "com-sky-dto-MenuDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDTO extends BaseDTO {
    /**
     * 菜单ID
     */
    @ApiModelProperty(value="菜单ID")
    private Long menuId;

    /**
     * 父菜单ID
     */
    @ApiModelProperty(value="父菜单ID")
    private Long parentId;

    /**
     * 父节点ID集合
     */
    @ApiModelProperty(value="父节点ID集合")
    private String parentIds;

    /**
     * 菜单名称
     */
    @NotBlank(message = "菜单名称不能为空")
    @ApiModelProperty(value="菜单名称")
    private String menuName;

    /**
     * 菜单类型（1目录 2菜单 3前台）
     */
    @NotBlank(message = "菜单类型不能为空")
    @ApiModelProperty(value="菜单类型（1目录 2菜单 3前台）")
    private String menuType;

    /**
     * 权限标识
     */
    @ApiModelProperty(value="权限标识")
    @NotBlank(message = "权限标识不能为空")
    private String percode;

    /**
     * 路由地址
     */
    @ApiModelProperty(value="路由地址")
    @NotBlank(message = "路由地址不能为空")
    private String path;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 菜单状态（0正常 1停用）
     */
    @NotBlank(message = "菜单状态不能为空")
    @ApiModelProperty(value="菜单状态（0正常 1停用）")
    private String status;
}
