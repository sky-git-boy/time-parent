package com.sky.controller;

import com.sky.dto.LogSmsInfoDTO;
import com.sky.service.LogSmsInfoService;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 消息日志管理控制器
 *
 * @author sky
 * @create 2021-11-30 9:42
 */
@RestController
@RequestMapping("/sms")
public class LogSmsInfoController {
    @Autowired
    private LogSmsInfoService smsInfoService;

    /**
     * 分页查询
     */
    @GetMapping("listSmsForPage")
    public R listSmsForPage(LogSmsInfoDTO smsDto) {
        DataGridView gridView = this.smsInfoService.listSmsPage(smsDto);
        return R.success("查询成功", gridView.getData(), gridView.getTotal());
    }

    /**
     * 根据ID查询一个
     */
    @GetMapping("getSmsById/{id}")
    public R getSmsById(@PathVariable @Validated @NotNull(message = "ID不能为空") Long id) {
        return R.success(this.smsInfoService.getById(id));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteSmsByIds/{ids}")
    public R deleteSmsByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] ids) {
        return R.toAjax(this.smsInfoService.deleteSmsByIds(ids));
    }
}
