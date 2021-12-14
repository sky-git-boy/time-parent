package com.sky.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @create 2021-11-30 9:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogOperInfoDTO extends BaseDTO {
    /**
     * 模块标题
     */
    @ApiModelProperty(value = "模块标题")
    @NotNull(message = "模块标题不能为空")
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除 4登录）")
    @NotNull(message = "业务类型不能为空")
    private String businessType;

    /**
     * 操作人员
     */
    @ApiModelProperty(value = "操作人员")
    private String operBy;

    /**
     * 操作状态（0正常 1异常）
     */
    @ApiModelProperty(value = "操作状态（0正常 1异常）")
    private String status;
}
