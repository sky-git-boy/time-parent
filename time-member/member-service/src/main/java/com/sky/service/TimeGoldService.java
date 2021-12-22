package com.sky.service;


import com.sky.domain.TimeGold;
import com.sky.dto.TimeGoldDTO;

/**
 * @author sky
 * @create 2021-12-15 10:32
 */
public interface TimeGoldService {

    TimeGold getOne(Long userId);

    int update(TimeGoldDTO dto);

    int insert(TimeGoldDTO dto);
}
