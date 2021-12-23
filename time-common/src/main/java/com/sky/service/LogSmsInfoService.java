package com.sky.service;

import com.sky.domain.LogSmsInfo;
import com.sky.dto.DataDTO;
import com.sky.dto.LogSmsInfoDTO;
import com.sky.vo.DataGridView;

import java.util.List;

/**
 * @author sky
 * @create 2021-11-30 9:41
 */
public interface LogSmsInfoService {

    // 分页查询
    DataGridView listSmsPage(LogSmsInfoDTO smsDto);

    // 获取详情
    LogSmsInfo getById(Long id);

    // 删除
    int deleteSmsByIds(Long[] ids);

    // 添加
    int insertSms(LogSmsInfo smsInfo);

    // 获取七日发送消息趋势
    List<DataDTO> getDataDays();

    // 获取发送消息总数
    int getSmsCount();
}
