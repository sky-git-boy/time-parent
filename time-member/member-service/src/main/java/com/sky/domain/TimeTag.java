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
 * 标签
 * @author sky
 * @create 2021-12-03 18:09
 */
@ApiModel(value = "com-sky-domain-TimeTag")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_tag")
public class TimeTag extends BaseEntity {
    /**
     * 标签ID
     */
    @TableId(value = "tag_id", type = IdType.AUTO)
    @ApiModelProperty(value = "标签ID")
    private Long tagId;

    /**
     * 标签名
     */
    @TableField(value = "tag_name")
    @ApiModelProperty(value = "标签名")
    private String tagName;

    /**
     * 标签颜色
     */
    @TableField(value = "color")
    @ApiModelProperty(value = "标签颜色")
    private String color;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    public static final String COL_TAG_ID = "tag_id";

    public static final String COL_TAG_NAME = "tag_name";

    public static final String COL_COLOR = "color";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}