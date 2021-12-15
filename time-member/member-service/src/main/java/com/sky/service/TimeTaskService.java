package com.sky.service;

import com.sky.domain.TimeTask;
import com.sky.dto.TimeTaskDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-15 11:11
 */
public interface TimeTaskService {

    // 通过状态获取任务
    List<TimeTask> getTaskByStatus(TimeTaskDTO dto);

    // 修改任务
    int updateTask(TimeTaskDTO dto);

    // 添加任务
    int addTask(TimeTaskDTO dto);

    // 删除
    int delete(Long id);

    // 获取详情
    TimeTaskDTO getOne(Long id);
}
