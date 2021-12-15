package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.domain.TimeJournal;
import com.sky.dto.TimeJournalDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeJournalService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sky
 * @create 2021-12-03 15:37
 */
@RestController
@Api(tags = "个人反省的控制器")
@RequestMapping("/journal")
@PreAuthorize("hasAuthority('diary')")
public class JournalController {

    @Autowired
    private TimeJournalService service;

    @GetMapping("/list")
    public R list(TimeJournalDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        DataGridView dataGridView = service.listPage(dto);
        return R.success("查询成功", dataGridView.getData(), dataGridView.getTotal());
    }

    /**
     * 添加反省
     */
    @PostMapping("/add")
    public R add(@RequestBody @Validated TimeJournalDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        int flag = this.service.add(dto);
        return R.toAjax(flag);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody @Validated TimeJournalDTO dto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        dto.setSimpleUser(user);
        int flag = this.service.update(dto);
        return R.toAjax(flag);
    }

    /**
     * 详情
     */
    @GetMapping("/getOne/{id}")
    public R getOne(@PathVariable("id") String id) {
        TimeJournal journal = this.service.getOne(id);
        return R.success(journal);
    }
}
