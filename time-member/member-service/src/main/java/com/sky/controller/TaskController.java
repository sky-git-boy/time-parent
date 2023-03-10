package com.sky.controller;

import com.sky.aspectj.annotation.Log;
import com.sky.aspectj.enums.BusinessType;
import com.sky.aspectj.enums.OperatorType;
import com.sky.domain.SimpleUser;
import com.sky.domain.TimeTask;
import com.sky.dto.KanBanDTO;
import com.sky.dto.TimeTaskDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeTaskService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @create 2021-12-15 11:18
 */
@RestController
@RequestMapping("/task")
@Api("个人任务控制器")
public class TaskController {

    @Autowired
    private TimeTaskService service;

    /**
     * todo看板
     */
    @GetMapping("/kanBan")
    @PreAuthorize("hasAuthority('todo_kanban')")
    public R kanBan(TimeTaskDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);

        KanBanDTO res = new KanBanDTO();
        for (int i=0; i<=3; i++) {
            dto.setStatus(i+"");
            if (i == 2) { // 已完成列表只显示今天完成的数据
                Date dNow = new Date();   //当前时间
                Date dBefore;

                Calendar calendar = Calendar.getInstance(); //得到日历
                calendar.setTime(dNow);//把当前时间赋给日历
                calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
                dBefore = calendar.getTime();   //得到前一天的时间

                dto.setBeginTime(dBefore);
                dto.setEndTime(dNow);
                List<TimeTask> list = this.service.getTodayDoneTaskList(dto);
                res.setDone(list);
                dto.setBeginTime(null); // 去掉时间选项 不然过期事项默认也会查询当天
                dto.setEndTime(null);
                continue;
            }

            List<TimeTask> list = this.service.getTaskList(dto);
            if (i==0)
                res.setTodo(list);
            else if (i==1)
                res.setDoing(list);
            else
                res.setExpire(list);
        }

        return R.success(res);
    }

    /**
     * 任务列表
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('todo')")
    public R list(TimeTaskDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.success(this.service.getTaskList(dto));
    }


    /**
     * 修改任务
     */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('todo')")
    @Log(title = "修改个人任务", businessType = BusinessType.UPDATE, operatorType = OperatorType.MEMBER)
    public R update(@RequestBody TimeTaskDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.toAjax(this.service.updateTask(dto));
    }

    /**
     * 添加任务
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('todo')")
    @Log(title = "添加个人任务", businessType = BusinessType.INSERT, operatorType = OperatorType.MEMBER)
    public R add(@RequestBody @Validated TimeTaskDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.toAjax(this.service.addTask(dto));
    }

    /**
     * 删除任务
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('todo')")
    @Log(title = "删除个人任务", businessType = BusinessType.DELETE, operatorType = OperatorType.MEMBER)
    public R delete(@PathVariable("id") Long id) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.service.delete(id));
    }

    /**
     * 获取详情
     */
    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasAuthority('todo')")
    public R getOne(@PathVariable("id") Long id) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.success(this.service.getOne(id));
    }
}
