package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.domain.SysNotice;
import com.sky.domain.TimeMusic;
import com.sky.dto.MusicDTO;
import com.sky.mapper.TimeMusicMapper;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.service.TimeMusicService;

import java.util.Arrays;
import java.util.Date;

/**
 * @author sky
 * @create 2021-12-21 11:09
 */
@Service
public class TimeMusicServiceImpl implements TimeMusicService {

    @Autowired
    private TimeMusicMapper mapper;
    
    @Override
    public DataGridView listPage(MusicDTO musicDTO) {
        Page<TimeMusic> page = new Page<>(musicDTO.getPageNum(), musicDTO.getPageSize());
        QueryWrapper<TimeMusic> qw = new QueryWrapper<>();
        // 查询条件
        qw.like(StringUtils.isNotBlank(musicDTO.getMusicName()), TimeMusic.COL_MUSIC_NAME, musicDTO.getMusicName());
        qw.eq(StringUtils.isNotBlank(musicDTO.getStatus()), TimeMusic.COL_STATUS, musicDTO.getStatus());
        qw.orderByDesc(SysNotice.COL_CREATE_TIME);
        this.mapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int addMusic(MusicDTO musicDTO) {
        TimeMusic music = new TimeMusic();
        BeanUtils.copyProperties(musicDTO, music);
        music.setCreateBy(musicDTO.getSimpleUser().getUserId());
        music.setCreateTime(new Date());
        return this.mapper.insert(music);
    }

    @Override
    public int updateMusic(MusicDTO musicDTO) {
        TimeMusic music = new TimeMusic();
        BeanUtils.copyProperties(musicDTO, music);
        music.setUpdateBy(musicDTO.getSimpleUser().getUserId());
        music.setUpdateTime(new Date());
        return this.mapper.updateById(music);
    }

    @Override
    public int deleteMusicByIds(Long[] musicIds) {
        if (musicIds != null && musicIds.length > 0) {
            return this.mapper.deleteBatchIds(Arrays.asList(musicIds));
        } else {
            return 0;
        }
    }

    @Override
    public MusicDTO getOne(Long musicId) {
        TimeMusic music = this.mapper.selectById(musicId);
        MusicDTO dto = new MusicDTO();
        BeanUtils.copyProperties(music, dto);
        return dto;
    }
}
