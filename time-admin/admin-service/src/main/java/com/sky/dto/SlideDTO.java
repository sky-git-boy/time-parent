package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author sky
 * @create 2021-12-01 15:47
 */
@ApiModel(value = "com-sky-dto-NoticeDto")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlideDTO extends BaseDTO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long slideId;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer slideSort;

    /**
     * 状态（0启用 1禁用）
     */
    @ApiModelProperty(value = "状态（0启用 1禁用）")
    private String status;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String picUrl;
}
