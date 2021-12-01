package com.sky.controller;

import com.sky.domain.SimpleUser;
import com.sky.dto.SlideDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeSlideService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 轮播图管理
 * @author sky
 * @create 2021-12-01 15:44
 */
@RestController
@RequestMapping("/slide")
@PreAuthorize("hasAuthority('portal_slide')")
public class TimSlideController {
    @Autowired
    private TimeSlideService slideService;

    // 分页查询
    @GetMapping("/listSlideForPage")
    public R listForPage(SlideDTO slideShowDto) {
        DataGridView dataGridView = slideService.listPage(slideShowDto);
        return R.success("查询成功", dataGridView.getData(), dataGridView.getTotal());
    }

    /**
     * 添加
     */
    @PostMapping("addSlide")
    public R addNotice(@RequestBody SlideDTO slideDTO) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        slideDTO.setSimpleUser(user);
        return R.toAjax(this.slideService.addSlide(slideDTO));
    }

    /**
     * 修改
     */
    @PutMapping("updateSlide")
    public R updateNotice(@RequestBody SlideDTO slideDTO) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        slideDTO.setSimpleUser(user);
        return R.toAjax(this.slideService.updateSlide(slideDTO));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteSlideByIds/{slideIds}")
    public R deleteNoticeByIds(@PathVariable @NotEmpty(message = "要删除的ID不能为空") Long[] slideIds) {
        return R.toAjax(this.slideService.deleteSlideByIds(slideIds));
    }

    /**
     * 根据ID查询一个
     */
    @GetMapping("getSlideById/{slide}")
    public R getSlideById(@PathVariable @NotNull(message = "轮播图Id") Long slide) {
        return R.success(this.slideService.getOne(slide));
    }
}
