package com.sky.controller;

import com.sky.aspectj.annotation.Log;
import com.sky.aspectj.enums.BusinessType;
import com.sky.aspectj.enums.OperatorType;
import com.sky.domain.SimpleUser;
import com.sky.domain.TimeEvent;
import com.sky.dto.TimeEventDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeEventService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sky
 * @create 2021-12-21 15:20
 */
@RestController
@Api(tags = "个人事件的控制器")
@RequestMapping("/event")
public class EventController {

    @Autowired
    private TimeEventService service;

    @GetMapping("/list")
    public R list(TimeEventDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.success(this.service.list(dto));
    }


    @PostMapping("/add")
    @Log(title = "添加个人事件", businessType = BusinessType.INSERT, operatorType = OperatorType.MEMBER)
    public R add(@RequestBody TimeEventDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.toAjax(this.service.addTask(dto));
    }

    @PutMapping("/update")
    @Log(title = "修改个人事件", businessType = BusinessType.UPDATE, operatorType = OperatorType.MEMBER)
    public R update(@RequestBody TimeEventDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.toAjax(this.service.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    @Log(title = "删除个人事件", businessType = BusinessType.DELETE, operatorType = OperatorType.MEMBER)
    public R delete(@PathVariable("id") Long id) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.service.delete(id));
    }

    @GetMapping("/getOne/{id}")
    public R getOne(@PathVariable("id") Long id) {
        return R.success(this.service.getOne(id));
    }

}
