package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.domain.LogSmsInfo;
import com.sky.dto.BaseDTO;
import com.sky.dto.DataDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-30 9:41
 */
public interface LogSmsInfoMapper extends BaseMapper<LogSmsInfo> {
    List<DataDTO> getDataDays();

    int getSmsCount();

    int getTaskCount();

    int getSlideCount();

    int getMusicCount();

    int getJournalCount();

    int getEventCount();

    int getNoticeCount();

    int getUserCount();

    int getOperCount();

    // 获取订单状态统计
    List<DataDTO> getOrderStatusCount(BaseDTO dto);

    // 获取订单类型统计
    List<DataDTO> getOrderTypeCount(BaseDTO dto);

    // 总收入
    Integer getOrderCount(BaseDTO dto);
}