package com.sky.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统菜单
 * @author sky
 * @create 2021-11-21 16:32
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "com-sky-domain-SysMenu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
public class SysMenu extends BaseEntity {
    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    /**
     * 父节点ID
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "父节点ID")
    private Long parentId;

    /**
     * 父节点ID集合
     */
    @TableField(value = "parent_ids")
    @ApiModelProperty(value = "父节点ID集合")
    private String parentIds;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    /**
     * 类型 1-目录 2-菜单
     */
    @TableField(value = "menu_type")
    @ApiModelProperty(value = "类型 1-目录 2-菜单")
    private String menuType;

    /**
     * 权限标识
     */
    @TableField(value = "percode")
    @ApiModelProperty(value = "权限标识")
    private String percode;

    /**
     * 路由地址
     */
    @TableField(value = "path")
    @ApiModelProperty(value = "路由地址")
    private String path;

    /**
     * 描述
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "描述")
    private String remark;

    /**
     * 菜单状态（0正常 1停用）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "菜单状态（0正常 1停用）")
    private String status;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建人")
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value = "修改人")
    private Long updateBy;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 删除标识（0正常 1删除）
     */
    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标识（0正常 1删除）")
    private String delFlag;

    public static final String COL_MENU_ID = "menu_id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_PARENT_KEY = "parent_key";

    public static final String COL_MENU_NAME = "menu_name";

    public static final String COL_MENU_TYPE = "menu_type";

    public static final String COL_PERCODE = "percode";

    public static final String COL_PATH = "path";

    public static final String COL_REMARK = "remark";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DEL_FLAG = "del_flag";
}