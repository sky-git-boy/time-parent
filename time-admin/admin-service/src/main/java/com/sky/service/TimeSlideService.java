package com.sky.service;


import com.sky.domain.TimeSlide;
import com.sky.dto.SlideDTO;
import com.sky.vo.DataGridView;

/**
 * @author sky
 * @create 2021-12-01 15:43
 */
public interface TimeSlideService {

    DataGridView listPage(SlideDTO slideShowDto);

    int addSlide(SlideDTO slideDTO);

    int updateSlide(SlideDTO slideDTO);

    int deleteSlideByIds(Long[] slideIds);

    TimeSlide getOne(Long slide);
}
