package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.LogOperInfo;
import com.sky.dto.DataDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-14 10:50
 */
public interface LogOperInfoMapper extends BaseMapper<LogOperInfo> {
    List<DataDTO> getDataDays();
}