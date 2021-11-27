package com.sky.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 表格数据传输对象
 */
@ApiModel(value = "com-sky-vo-DataGridView")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView implements Serializable {
    private static final long serialVersionUID=1L;

    private Long total;
    private List<?> data;

}
