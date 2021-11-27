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
 * 字典类型表
 * @author sky
 * @create 2021-11-27 15:18
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "com-sky-domain-SysDictType")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_dict_type")
public class SysDictType extends BaseEntity {
    /**
     * 字典主键
     */
    @TableId(value = "dict_id", type = IdType.AUTO)
    @ApiModelProperty(value = "字典主键")
    private Long dictId;

    /**
     * 字典名称
     */
    @TableField(value = "dict_name")
    @ApiModelProperty(value = "字典名称")
    private String dictName;

    /**
     * 字典类型
     */
    @TableField(value = "dict_type")
    @ApiModelProperty(value = "字典类型")
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建者")
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    public static final String COL_DICT_ID = "dict_id";

    public static final String COL_DICT_NAME = "dict_name";

    public static final String COL_DICT_TYPE = "dict_type";

    public static final String COL_STATUS = "status";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";
}