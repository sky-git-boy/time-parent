package com.sky.service;

import com.sky.dto.TimeTagDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-03 18:09
 */
public interface TimeTagService {
    // 展示标签
    List<TimeTagDTO> list(Long userId);

    // 添加
    int saveOrUpdate(TimeTagDTO dto, Long userId);

    // 添加
    int delete(Long id);

}
