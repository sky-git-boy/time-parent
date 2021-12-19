package com.sky.service;

import com.sky.domain.TimeTask;
import com.sky.dto.TimeTaskDTO;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-15 11:11
 */
public interface TimeTaskService {

    // 获取任务列表
    List<TimeTask> getTaskList(TimeTaskDTO dto);

    // 修改任务
    int updateTask(TimeTaskDTO dto);

    // 添加任务
    int addTask(TimeTaskDTO dto);

    // 删除
    int delete(Long id);

    // 获取详情
    TimeTask getOne(Long id);
}
