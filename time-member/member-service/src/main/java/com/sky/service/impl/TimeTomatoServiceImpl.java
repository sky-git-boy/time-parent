package com.sky.service.impl;

import com.sky.dto.TimeTomatoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.TimeTomatoMapper;
import com.sky.domain.TimeTomato;
import com.sky.service.TimeTomatoService;

/**
 * @author sky
 * @create 2021-12-03 17:35
 */
@Service
public class TimeTomatoServiceImpl extends ServiceImpl<TimeTomatoMapper, TimeTomato> implements TimeTomatoService {

    @Autowired
    private TimeTomatoMapper mapper;

    @Override
    public int add(TimeTomatoDTO dto) {
        TimeTomato bean = new TimeTomato();
        BeanUtils.copyProperties(dto, bean);
        bean.setUserId(dto.getUserId());
        long end = dto.getEndTime().getTime();
        long start = dto.getStartTime().getTime();
        bean.setTime((int) ((end - start)/(24*60*60*60*1000)));
        return this.mapper.insert(bean);
    }
}
