package com.sky.controller;

import com.sky.dto.LogOperInfoDTO;
import com.sky.service.LogOperInfoService;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @create 2021-11-30 9:51
 */
@RestController
@RequestMapping("/operLog")
public class LogOperInfoController {
    
    @Autowired
    private LogOperInfoService operInfoService;
    
    /**
     * 分页查询
     */
    @GetMapping("/listForPage")
    public R listForPage(LogOperInfoDTO operLogDto) {
        DataGridView dataGridView = this.operInfoService.listForPage(operLogDto);
        return R.success("查询成功", dataGridView.getData(), dataGridView.getTotal());
    }


    /**
     * 根据ID删除操作日志信息
     */
    @DeleteMapping("/deleteOperLogByIds/{infoIds}")
    @PreAuthorize("hasAuthority('oper-log')")
    public R deleteOperLogByIds(@PathVariable @Validated @NotNull(message = "删除ID不能为空") Long[] infoIds) {
        return R.toAjax(this.operInfoService.deleteOperLogByIds(infoIds));
    }

    /**
     * 清空所有操作日志
     */
    @DeleteMapping("/clearAllOperLog")
    @PreAuthorize("hasAuthority('oper-log')")
    public R clearAllOperLog() {
        return R.toAjax(this.operInfoService.clearAllOperLog());
    }
}
