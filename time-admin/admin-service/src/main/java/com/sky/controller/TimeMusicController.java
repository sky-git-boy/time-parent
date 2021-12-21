package com.sky.controller;

import com.sky.aspectj.annotation.Log;
import com.sky.aspectj.enums.BusinessType;
import com.sky.domain.SimpleUser;
import com.sky.dto.MusicDTO;
import com.sky.exception.BusinessException;
import com.sky.service.TimeMusicService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.DataGridView;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 白噪音管理
 * @author sky
 * @create 2021-12-21 11:16
 */
@RestController
@Api(tags = "白噪音管理")
@RequestMapping("/music")
public class TimeMusicController {
    
    @Autowired
    private TimeMusicService musicService;

    @GetMapping("/listMusicForPage")
    public R listForPage(MusicDTO musicDTO) {
        DataGridView dataGridView = musicService.listPage(musicDTO);
        return R.success("查询成功", dataGridView.getData(), dataGridView.getTotal());
    }
    
    /**
     * 添加
     */
    @PostMapping("addMusic")
    @PreAuthorize("hasAuthority('portal_music')")
    @Log(title = "添加轮播图", businessType = BusinessType.INSERT)
    public R addNotice(@RequestBody MusicDTO musicDTO) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        musicDTO.setSimpleUser(user);
        return R.toAjax(this.musicService.addMusic(musicDTO));
    }

    /**
     * 修改
     */
    @PutMapping("updateMusic")
    @PreAuthorize("hasAuthority('portal_music')")
    @Log(title = "修改轮播图", businessType = BusinessType.UPDATE)
    public R updateNotice(@RequestBody MusicDTO musicDTO) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        musicDTO.setSimpleUser(user);
        return R.toAjax(this.musicService.updateMusic(musicDTO));
    }

    /**
     * 删除
     */
    @DeleteMapping("deleteMusicByIds/{musicIds}")
    @PreAuthorize("hasAuthority('portal_music')")
    @Log(title = "删除轮播图", businessType = BusinessType.DELETE)
    public R deleteNoticeByIds(@PathVariable @NotEmpty(message = "要删除的ID不能为空") Long[] musicIds) {
        return R.toAjax(this.musicService.deleteMusicByIds(musicIds));
    }

    /**
     * 根据ID查询一个
     */
    @GetMapping("getMusicById/{music}")
    public R getMusicById(@PathVariable @NotNull(message = "轮播图Id") Long music) {
        return R.success(this.musicService.getOne(music));
    }
}
