package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.domain.TimeSlide;
import com.sky.dto.SlideDTO;
import com.sky.mapper.TimeSlideMapper;
import com.sky.service.TimeSlideService;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;


/**
 * @author sky
 * @create 2021-12-01 15:43
 */
@Service
public class TimeSlideServiceImpl implements TimeSlideService {

    @Autowired
    private TimeSlideMapper mapper;

    @Override
    public DataGridView listPage(SlideDTO slideShowDto) {
        QueryWrapper<TimeSlide> qw = new QueryWrapper<>();
        Page<TimeSlide> page = new Page<>(slideShowDto.getPageNum(), slideShowDto.getPageSize());
        qw.eq(StringUtils.isNotEmpty(slideShowDto.getStatus()), TimeSlide.COL_STATUS, slideShowDto.getStatus());
        qw.orderByDesc(TimeSlide.COL_SLIDE_SORT);
        this.mapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int addSlide(SlideDTO slideDTO) {
        TimeSlide slide = new TimeSlide();
        BeanUtils.copyProperties(slideDTO, slide);
        slide.setCreateBy(slideDTO.getSimpleUser().getUserId());
        slide.setCreateTime(new Date());
        return this.mapper.insert(slide);
    }

    @Override
    public int updateSlide(SlideDTO slideDTO) {
        TimeSlide slide = new TimeSlide();
        BeanUtils.copyProperties(slideDTO, slide);
        slide.setUpdateBy(slideDTO.getSimpleUser().getUserId());
        slide.setUpdateTime(new Date());
        return this.mapper.updateById(slide);
    }

    @Override
    public int deleteSlideByIds(Long[] slideIds) {
        if (null != slideIds && slideIds.length > 0) {
            return this.mapper.deleteBatchIds(Arrays.asList(slideIds));
        }
        return 0;
    }

    @Override
    public TimeSlide getOne(Long slide) {
        return this.mapper.selectById(slide);
    }
}
