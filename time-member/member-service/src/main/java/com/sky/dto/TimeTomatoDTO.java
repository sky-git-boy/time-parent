package com.sky.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sky.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 番茄时钟表
 * @author sky
 * @create 2021-12-03 17:35
 */
@ApiModel(value = "com-sky-domain-TimeTomatoDTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TimeTomatoDTO extends BaseDTO {
    /**
     * 番茄时钟ID
     */
    @ApiModelProperty(value = "番茄时钟ID")
    private Long tomatoId;

    /**
     * 番茄时钟名称
     */
    @ApiModelProperty(value = "番茄时钟名称")
    private String tomatoName;

    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id")
    private Long userId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}