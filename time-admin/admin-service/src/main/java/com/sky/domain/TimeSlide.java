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
 * 轮播图表
 * @author sky
 * @create 2021-12-01 15:43
 */
@ApiModel(value = "com-sky-domain-TimeSlide")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_slide")
public class TimeSlide extends BaseEntity {
    /**
     * id
     */
    @TableId(value = "slide_id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long slideId;

    /**
     * 显示顺序
     */
    @TableField(value = "slide_sort")
    @ApiModelProperty(value = "显示顺序")
    private Integer slideSort;

    /**
     * 状态（0启用 1禁用）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态（0启用 1禁用）")
    private String status;

    /**
     * 图片地址
     */
    @TableField(value = "pic_url")
    @ApiModelProperty(value = "图片地址")
    private String picUrl;

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

    public static final String COL_SLIDE_ID = "slide_id";

    public static final String COL_SLIDE_SORT = "slide_sort";

    public static final String COL_STATUS = "status";

    public static final String COL_PIC_URL = "pic_url";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";
}