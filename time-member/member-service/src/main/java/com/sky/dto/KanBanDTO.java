package com.sky.dto;

import com.sky.domain.TimeTask;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * todo看板返回值
 * @author sky
 * @create 2021-12-16 20:04
 */
@ApiModel(value = "com-sky-domain-KanBanDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KanBanDTO {

    @ApiModelProperty("待办")
    private List<TimeTask> todo;

    @ApiModelProperty("进行中")
    private List<TimeTask> doing;

    @ApiModelProperty("已办")
    private List<TimeTask> done;

    @ApiModelProperty("过期")
    private List<TimeTask> expire;

}
