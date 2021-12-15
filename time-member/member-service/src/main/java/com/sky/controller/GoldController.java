package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.dto.TimeGoldDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeGoldService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sky
 * @create 2021-12-15 10:33
 */
@RestController
@Api(tags = "个人目标的控制器")
@RequestMapping("/goal")
public class GoldController {

    @Autowired
    private TimeGoldService service;

    @GetMapping("/list")
    public R list(@RequestBody TimeGoldDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        DataGridView dataGridView = this.service.list(dto);
        return R.success("查询成功", dataGridView.getData(), dataGridView.getTotal());
    }

    @PostMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody TimeGoldDTO dto) {
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
}
