package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.constants.Constants;
import com.sky.domain.TimeTask;
import com.sky.dto.TimeTaskDTO;
import com.sky.dto.YearDoneCountDTO;
import com.sky.mapper.TimeTaskMapper;
import com.sky.service.TimeTaskService;
import com.sky.utils.IdGeneratorSnowflake;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                .orderByDesc(TimeTask::getEndTime)
        );
    }

    @Override
    public List<TimeTask> getTodayDoneTaskList(TimeTaskDTO dto) {
        return this.mapper.selectList(new LambdaQueryWrapper<TimeTask>()
                .eq(TimeTask::getUserId, dto.getSimpleUser().getUserId())
                .eq(StringUtils.isNotEmpty(dto.getStatus()), TimeTask::getStatus, dto.getStatus())
                .like(StringUtils.isNotEmpty(dto.getTitle()), TimeTask::getTitle, dto.getTitle())
                .like(StringUtils.isNotEmpty(dto.getTags()), TimeTask::getTags, dto.getTags())
                .ge(null != dto.getBeginTime(), TimeTask::getDoneTime, dto.getBeginTime())
                .le(null != dto.getQEndTime(), TimeTask::getDoneTime, dto.getQEndTime())
                .orderByDesc(TimeTask::getDoneTime)
        );
    }

    @Override
    public int updateTask(TimeTaskDTO dto) {
        TimeTask task = new TimeTask();
        BeanUtils.copyProperties(dto, task);
        // 已完成（添加完成时间）
        if (task.getStatus().equals(Constants.TASK_STATUS_DONE)) {
            task.setDoneTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        } else {
            task.setDoneTime("");
        }
        return this.mapper.updateById(task);
    }

    @Override
    public int addTask(TimeTaskDTO dto) {
        TimeTask task = new TimeTask();
        BeanUtils.copyProperties(dto, task);
        task.setUserId(dto.getSimpleUser().getUserId());
        task.setTaskId(IdGeneratorSnowflake.snowflakeId());
        // 已完成（添加完成时间）
        if (null != task.getStatus() && task.getStatus().equals(Constants.TASK_STATUS_DONE)) {
            task.setDoneTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        }
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

    @Override
    public Object[] doneCount(Long userId) {
        List<Object[]> res = new ArrayList<>();
        this.mapper.doneCunt(userId).forEach(s -> {
            res.add(new Object[]{s.getTime(), s.getCount()});
        });
        return res.toArray();
    }


}
