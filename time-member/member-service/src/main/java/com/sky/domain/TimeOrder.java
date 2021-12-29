package com.sky.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收费表
 * @author sky
 * @create 2021-12-29 16:37
 */
@ApiModel(value = "com-sky-domain-TimeOrder")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "time_order")
public class TimeOrder extends BaseEntity {
    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.INPUT)
    @ApiModelProperty(value = "订单id")
    private Long orderId;

    /**
     * 费用
     */
    @TableField(value = "order_amount")
    @ApiModelProperty(value = "费用")
    private BigDecimal orderAmount;

    /**
     * 订单状态0未支付  1 支付成功  2支付超时 3支付失败
     */
    @TableField(value = "order_status")
    @ApiModelProperty(value = "订单状态0未支付  1 支付成功  2支付超时 3支付失败")
    private String orderStatus;

    /**
     *  订单项目 0一个月 1半年 2一年 3永久
     */
    @TableField(value = "order_item")
    @ApiModelProperty(value = " 订单项目 0一个月 1半年 2一年 3永久")
    private String orderItem;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 支付时间
     */
    @TableField(value = "pay_time")
    @ApiModelProperty(value = "支付时间")
    private Date payTime;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ORDER_AMOUNT = "order_amount";

    public static final String COL_ORDER_STATUS = "order_status";

    public static final String COL_ORDER_ITEM = "order_item";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_PAY_TIME = "pay_time";
}