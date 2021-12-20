package com.sky.controller;

import com.sky.aspectj.annotation.Log;
import com.sky.aspectj.enums.BusinessType;
import com.sky.domain.SimpleUser;
import com.sky.dto.NoticeDTO;
import com.sky.exception.BusinessException;
import com.sky.service.SysNoticeService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 通知公告控制器
 * @author sky
 * @create 2021-11-29 23:06
 */
@RestController
@RequestMapping("/notice")
public class SysNoticeController {

    @Autowired
    private SysNoticeService noticeService;

    /**
     * 分页查询
     */
    @GetMapping("listNoticeForPage")
    public R listNoticeForPage(NoticeDTO noticeDto){
        DataGridView gridView = this.noticeService.listNoticePage(noticeDto);
        return R.success("查询成功", gridView.getData(), gridView.getTotal());
    }
    /**
     * 添加
     */
    @PostMapping("addNotice")
    @PreAuthorize("hasAuthority('portal_notice')")
    @Log(title = "添加公告", businessType = BusinessType.INSERT)
    public R addNotice(@RequestBody @Validated NoticeDTO noticeDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        noticeDto.setSimpleUser(user);
        return R.toAjax(this.noticeService.addNotice(noticeDto));
    }

    /**
     * 修改
     */
    @PutMapping("updateNotice")
    @PreAuthorize("hasAuthority('portal_notice')")
    @Log(title = "修改公告", businessType = BusinessType.UPDATE)
    public R updateNotice(@RequestBody @Validated NoticeDTO noticeDto) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        noticeDto.setSimpleUser(user);
        return R.toAjax(this.noticeService.updateNotice(noticeDto));
    }


    /**
     * 根据ID查询一个通知公告信息
     */
    @GetMapping("getNoticeById/{noticeId}")
    public R getNoticeById(@PathVariable @Validated @NotNull(message = "通知公告ID不能为空") Long noticeId) {
        return R.success(this.noticeService.getOne(noticeId));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteNoticeByIds/{noticeIds}")
    @PreAuthorize("hasAuthority('portal_notice')")
    @Log(title = "删除公告", businessType = BusinessType.DELETE)
    public R deleteNoticeByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] noticeIds) {
        return R.toAjax(this.noticeService.deleteNoticeByIds(noticeIds));
    }


}
