package com.sky.controller;

import com.sky.service.MemberStatService;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @create 2021-12-23 15:09
 */
@RestController
@Api(tags = "前台系统统计模块控制器")
@RequestMapping("/portal")
@PreAuthorize("hasAuthority('statistic')")
public class MemberStatController {

    @Autowired
    private MemberStatService memberStatService;

    @GetMapping("/mixedChart")
    @ApiOperation("各类创建数")
    public R mixedChart() {
        return R.success(memberStatService.mixChart());
    }

    @GetMapping("/lineChartSimple")
    @ApiOperation("最近已完成趋势")
    public R lineChartSimple() {
        return R.success(memberStatService.lineChartSimple());
    }

    @GetMapping("/columnChart")
    @ApiOperation("近七日任务数")
    public R columnChart() {
        return R.success(memberStatService.columnChart());
    }

    @GetMapping("/pieChart")
    @ApiOperation("任务各状态数")
    public R pieChart() {
        return R.success(memberStatService.pieChart());
    }
}
