package com.sky.service;

import com.sky.domain.TimeGold;
import com.sky.dto.TimeGoldDTO;
import com.sky.vo.DataGridView;

/**
 * @author sky
 * @create 2021-12-15 10:32
 */
public interface TimeGoldService {

    DataGridView list(TimeGoldDTO dto);

    int saveOrUpdate(TimeGoldDTO dto, Long userId);

    int delete(Long id);

    TimeGold getOne(Long id);
}
