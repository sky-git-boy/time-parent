package com.sky.service;

import com.sky.dto.MusicDTO;
import com.sky.vo.DataGridView;

/**
 * @author sky
 * @create 2021-12-21 11:09
 */
public interface TimeMusicService {

    DataGridView listPage(MusicDTO musicDTO);

    int addMusic(MusicDTO musicDTO);

    int updateMusic(MusicDTO musicDTO);

    int deleteMusicByIds(Long[] musicIds);

    MusicDTO getOne(Long musicId);
}
