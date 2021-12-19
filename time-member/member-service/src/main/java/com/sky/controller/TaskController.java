package com.sky.controller;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public R kanBan(TimeTaskDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);

        KanBanDTO res = new KanBanDTO();
        for (int i=0; i<3; i++) {
            dto.setStatus(i+"");
            List<TimeTask> list = this.service.getTaskList(dto);
            if (i==0)
                res.setTodo(list);
            else if (i==1)
                res.setDoing(list);
            else
                res.setDone(list);
        }

        return R.success(res);
    }

    /**
     * 任务列表
     */
    @GetMapping("/list")
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
    public R getOne(@PathVariable("id") Long id) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.success(this.service.getOne(id));
    }
}
