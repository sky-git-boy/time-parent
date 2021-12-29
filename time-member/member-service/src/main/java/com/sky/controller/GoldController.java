package com.sky.controller;


import com.sky.domain.SimpleUser;
import com.sky.domain.TimeGold;
import com.sky.dto.TimeGoldDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeGoldService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author sky
 * @create 2021-12-15 10:33
 */
@RestController
@Api(tags = "个人目标的控制器")
@RequestMapping("/goal")
@PreAuthorize("hasAuthority('goal')")
public class GoldController {

    @Autowired
    private TimeGoldService service;

    @GetMapping("/getByUser")
    public R getGoal() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        return R.success(service.getOne(user.getUserId()));
    }

    @PutMapping("/update")
    public R updateGoal(@RequestBody TimeGoldDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.toAjax(service.update(dto));
    }

    @PostMapping("/insert")
    public R insertGoal(@RequestBody TimeGoldDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        return R.toAjax(service.insert(dto));
    }
}
