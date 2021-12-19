package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.domain.TimeTask;
import com.sky.dto.TimeTaskDTO;
import com.sky.mapper.TimeTaskMapper;
import com.sky.service.TimeTaskService;
import com.sky.utils.IdGeneratorSnowflake;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author sky
 * @create 2021-12-15 11:11
 */
@Service
public class TimeTaskServiceImpl implements TimeTaskService {

    @Autowired
    private TimeTaskMapper mapper;

    @Override
    public List<TimeTask> getTaskList(TimeTaskDTO dto) {
        return this.mapper.selectList(new LambdaQueryWrapper<TimeTask>()
                .eq(TimeTask::getUserId, dto.getSimpleUser().getUserId())
                .eq(StringUtils.isNotEmpty(dto.getStatus()), TimeTask::getStatus, dto.getStatus())
                .like(StringUtils.isNotEmpty(dto.getTitle()), TimeTask::getTitle, dto.getTitle())
                .like(StringUtils.isNotEmpty(dto.getTags()), TimeTask::getTags, dto.getTags())
                .ge(null != dto.getBeginTime(), TimeTask::getEndTime, dto.getBeginTime())
                .le(null != dto.getQEndTime(), TimeTask::getEndTime, dto.getQEndTime())
        );
    }

    @Override
    public int updateTask(TimeTaskDTO dto) {
        TimeTask task = new TimeTask();
        BeanUtils.copyProperties(dto, task);
        return this.mapper.updateById(task);
    }

    @Override
    public int addTask(TimeTaskDTO dto) {
        TimeTask task = new TimeTask();
        BeanUtils.copyProperties(dto, task);
        task.setUserId(dto.getSimpleUser().getUserId());
        task.setTaskId(IdGeneratorSnowflake.snowflakeId());
        return this.mapper.insert(task);
    }

    @Override
    public int delete(Long id) {
        return this.mapper.deleteById(id);
    }

    @Override
    public TimeTask getOne(Long id) {
        return this.mapper.selectById(id);
    }


}
