package com.sky.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.domain.SimpleUser;
import com.sky.domain.TimeRules;
import com.sky.dto.TimeRulesDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeRulesService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 用户奖赏
 * @author sky
 * @create 2021-12-30 14:08
 */
@RestController
@RequestMapping("rules")
public class RulesController {

    @Autowired
    private TimeRulesService rulesService;

    @PostMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody TimeRulesDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }

        TimeRules rules = new TimeRules();
        BeanUtils.copyProperties(dto, rules);
        if (dto.getId() == null) {
            rules.setUserId(user.getUserId());
            rules.setCreateTime(new Date());
        }
        int i = this.rulesService.saveOrUpdate(rules) ? 1 : 0;
        return R.toAjax(i);
    }


    @GetMapping("/list")
    public R list() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        List<TimeRules> res = this.rulesService.list(new LambdaQueryWrapper<TimeRules>().eq(TimeRules::getUserId, user.getUserId()));
        return R.success(res);
    }

    @DeleteMapping("/delete/{ids}")
    public R delete(@PathVariable("ids") Long[] ids) {
        if (ids != null && ids.length > 0) {
            boolean remove = this.rulesService.removeByIds(Arrays.asList(ids));
            return R.toAjax(remove ? 1 : 0);
        } else {
            return R.fail();
        }
    }
}
