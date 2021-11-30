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
 * 短息发送记录表
 * @author sky
 * @create 2021-11-30 9:41
 */
@ApiModel(value = "com-sky-domain-LogSmsInfo")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "log_sms_info")
public class LogSmsInfo extends BaseEntity {
    /**
     * 表id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "表id")
    private Long id;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 发送时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "发送时间")
    private Date createTime;

    /**
     * 验证码
     */
    @TableField(value = "code")
    @ApiModelProperty(value = "验证码")
    private String code;

    /**
     * 0发送成功 1发送失败
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "0发送成功 1发送失败")
    private String status;

    /**
     * 0注册验证码 1修改密码
     */
    @TableField(value = "type")
    @ApiModelProperty(value = "0注册验证码 1修改密码")
    private String type;

    /**
     * 发送失败的错误信息
     */
    @TableField(value = "error_info")
    @ApiModelProperty(value = "发送失败的错误信息")
    private String errorInfo;

    public static final String COL_ID = "id";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_CODE = "code";

    public static final String COL_STATUS = "status";

    public static final String COL_TYPE = "type";

    public static final String COL_ERROR_INFO = "error_info";
}