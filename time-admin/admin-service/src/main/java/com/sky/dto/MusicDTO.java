package com.sky.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 白噪音
 * @author sky
 * @create 2021-12-21 11:09
 */
@ApiModel(value = "com-sky-domain-MusicDTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicDTO extends BaseDTO {
    /**
     * 白噪音Id
     */
    @ApiModelProperty(value = "白噪音Id")
    private Long musicId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String musicName;

    /**
     * 音频url
     */
    @ApiModelProperty(value = "音频url")
    private String musicUrl;

    /**
     * 背景url
     */
    @ApiModelProperty(value = "背景url")
    private String picUrl;

    /**
     * 状态（0正常 1禁用）
     */
    @ApiModelProperty(value = "状态（0正常 1禁用）")
    private String status;
}