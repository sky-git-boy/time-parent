package com.sky.controller;

import com.sky.service.AdminStatService;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台系统统计模块控制器
 * @author sky
 * @create 2021-12-23 10:23
 */
@RestController
@Api(tags = "后台系统统计模块控制器")
@RequestMapping("/backend")
public class AdminStatController {

    @Autowired
    private AdminStatService adminStatService;

    @GetMapping("/lineChart")
    @ApiOperation("登录及发送短信趋势")
    public R lineChart() {
        return R.success(adminStatService.lineChart());
    }

    @GetMapping("/getAllCount")
    @ApiOperation("各内容总数")
    public R getAllCount() {
        return R.success(adminStatService.getAllCount());
    }

    @GetMapping("/pieChart")
    @ApiOperation("各内容总数")
    public R pieChart() {
        return R.success(adminStatService.pieChart());
    }

    @GetMapping("/systemChart")
    @ApiOperation("各内容总数")
    public R systemChart() {
        return R.success(adminStatService.systemChart());
    }

    @GetMapping("/barChart")
    @ApiOperation("近七日操作数")
    public R barChart() {
        return R.success(adminStatService.barChart());
    }

}
