package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.dto.TimeTagDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeTagService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sky
 * @create 2021-12-03 18:10
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TimeTagService service;

    @GetMapping("/list")
    public R list() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.success(this.service.list(user.getUserId()));
    }

    @PostMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody TimeTagDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.service.saveOrUpdate(dto, user.getUserId()));
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable("id") Long id) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.toAjax(this.service.delete(id));
    }

    @GetMapping("/getOne/{id}")
    public R getOne(@PathVariable("id") Long id) {
        return R.success(this.service);
    }
}
