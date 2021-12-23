package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.LogSmsInfo;
import com.sky.dto.DataDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-30 9:41
 */
public interface LogSmsInfoMapper extends BaseMapper<LogSmsInfo> {
    List<DataDTO> getDataDays();

    Long getSmsCount();

    Long getTaskCount();

    Long getSlideCount();

    Long getMusicCount();

    Long getJournalCount();

    Long getEventCount();

    Long getNoticeCount();

    Long getUserCount();
}