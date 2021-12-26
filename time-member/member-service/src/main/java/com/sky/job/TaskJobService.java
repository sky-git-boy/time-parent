package com.sky.job;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.constants.Constants;
import com.sky.domain.TimeTask;
import com.sky.mapper.TimeTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 定时扫描任务待办
 * @author sky
 * @create 2021-12-26 14:08
 */
@Service
public class TaskJobService {

    @Autowired
    private TimeTaskMapper taskMapper;

    // 每天6点扫描待办
    @Scheduled(cron = "0 0 18 * * ?")
    public void test() {

        // 设置待修改待办的列表
        List<TimeTask> updateList = new ArrayList<>();
        Date now = new Date();

        // 查询待办及进行中
        ArrayList<String> queryList = new ArrayList<>();
        queryList.add(Constants.TASK_STATUS_TODO);
        queryList.add(Constants.TASK_STATUS_DOING);

        // 获取所有未完成待办
        this.taskMapper.selectList(
                new LambdaQueryWrapper<TimeTask>().in(TimeTask::getStatus, queryList)
        ).forEach(item -> {
            // 如果当前时间在截止时间之后，则为过期
            if (now.after(item.getEndTime())) {
                updateList.add(item);
            }
        });

        // 修改待办状态
        updateList.forEach(item -> {
            item.setStatus(Constants.TASK_STATUS_EXPIRE);
            taskMapper.updateById(item);
        });
    }
}
