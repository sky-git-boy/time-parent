package com.sky.service;

import com.sky.domain.LogOperInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.dto.LogOperInfoDTO;
import com.sky.vo.DataGridView;

/**
 * @author sky
 * @create 2021-11-30 9:51
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
}
