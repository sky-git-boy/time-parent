package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.exception.BusinessException;
import com.sky.service.TimeTaskService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @create 2021-12-19 15:03
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private TimeTaskService service;

    @ApiModelProperty("一年内完成事项的数量")
    @GetMapping("doneCount")
    public R doneCount() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.success(this.service.doneCount(user.getUserId()));
    }

}
