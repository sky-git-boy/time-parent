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
 * 白噪音
 * @author sky
 * @create 2021-12-21 11:09
 */
@ApiModel(value = "com-sky-domain-TimeMusic")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_music")
public class TimeMusic extends BaseEntity {
    /**
     * 白噪音Id
     */
    @TableId(value = "music_id", type = IdType.INPUT)
    @ApiModelProperty(value = "白噪音Id")
    private Long musicId;

    /**
     * 名称
     */
    @TableField(value = "music_name")
    @ApiModelProperty(value = "名称")
    private String musicName;

    /**
     * 音频url
     */
    @TableField(value = "music_url")
    @ApiModelProperty(value = "音频url")
    private String musicUrl;

    /**
     * 背景url
     */
    @TableField(value = "pic_url")
    @ApiModelProperty(value = "背景url")
    private String picUrl;

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
     * 修改者
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value = "修改者")
    private Long updateBy;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 状态（0正常 1禁用）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态（0正常 1禁用）")
    private String status;

    public static final String COL_MUSIC_ID = "music_id";

    public static final String COL_MUSIC_NAME = "music_name";

    public static final String COL_MUSIC_URL = "music_url";

    public static final String COL_PIC_URL = "pic_url";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_STATUS = "status";
}