package com.sky.dto;

import lombok.Data;

/**
 * 数据统计 DTO
 * @author sky
 * @create 2021-12-23 10:47
 */
@Data
public class DataDTO {
    // MM-dd
    private String days;

    // 数量
    private int count;
}
