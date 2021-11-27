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
 * 用户信息表
 * @author sky
 * @create 2021-11-21 16:32
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "com-sky-domain-SysUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 用户姓名
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value = "用户姓名")
    private String userName;

    /**
     * 用户类型（0后台用户 1前台用户）
     */
    @TableField(value = "user_type")
    @ApiModelProperty(value = "用户类型（0后台用户 1前台用户）")
    private String userType;

    /**
     * 电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    /**
     * 用户头像
     */
    @TableField(value = "picture")
    @ApiModelProperty(value = "用户头像")
    private String picture;

    /**
     * 密码
     */
    @TableField(value = "password")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    private String status;

    /**
     * 用户授权登录openid 扩展第三方登陆使用
     */
    @TableField(value = "open_id")
    @ApiModelProperty(value = "用户授权登录openid 扩展第三方登陆使用")
    private String openId;

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

    /**
     * 删除标志（0正常 1删除）
     */
    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标志（0正常 1删除）")
    private String delFlag;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_USER_TYPE = "user_type";

    public static final String COL_PHONE = "phone";

    public static final String COL_EMAIL = "email";

    public static final String COL_PICTURE = "picture";

    public static final String COL_PASSWORD = "password";

    public static final String COL_STATUS = "status";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DEL_FLAG = "del_flag";
}