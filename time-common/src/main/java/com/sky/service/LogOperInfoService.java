package com.sky.service;

import com.sky.domain.LogOperInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.DataDTO;
import com.sky.dto.LogOperInfoDTO;
import com.sky.vo.DataGridView;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-14 10:50
 */
public interface LogOperInfoService extends IService<LogOperInfo> {

    // 分页查询
    DataGridView listForPage(LogOperInfoDTO operLogDto);

    // 删除
    int deleteOperLogByIds(Long[] infoIds);

    // 清除全部
    int clearAllOperLog();

    // 插入操作日志
    int insertOperLog(LogOperInfo operLog);

    // 获取七日用户登录趋势
    List<DataDTO> getDataDays();

}
