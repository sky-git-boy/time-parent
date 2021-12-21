package com.sky.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.domain.TimeEvent;
import com.sky.dto.TimeEventDTO;
import com.sky.mapper.TimeEventMapper;
import com.sky.service.TimeEventService;
import com.sky.utils.IdGeneratorSnowflake;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sky
 * @create 2021-12-21 15:18
 */
@Service
public class TimeEventServiceImpl implements TimeEventService {

    @Autowired
    private TimeEventMapper mapper;

    @Override
    public int addTask(TimeEventDTO dto) {
        TimeEvent event = new TimeEvent();
        BeanUtils.copyProperties(dto, event);
        event.setId(IdGeneratorSnowflake.snowflakeId());
        event.setUserId(dto.getSimpleUser().getUserId());
        return this.mapper.insert(event);
    }

    @Override
    public int update(TimeEventDTO dto) {
        TimeEvent event = new TimeEvent();
        BeanUtils.copyProperties(dto, event);
        return this.mapper.updateById(event);
    }

    @Override
    public int delete(Long id) {
        return this.mapper.deleteById(id);
    }

    @Override
    public List<TimeEventDTO> list(TimeEventDTO dto) {
        List<TimeEventDTO> res = new ArrayList<>();
        this.mapper.selectList(
                new LambdaQueryWrapper<TimeEvent>()
                        .eq(TimeEvent::getUserId, dto.getSimpleUser().getUserId())
        ).forEach(s ->{
            TimeEventDTO eventDTO = new TimeEventDTO();
            BeanUtils.copyProperties(s, eventDTO);
            res.add(eventDTO);
        });
        return res;
    }

    @Override
    public TimeEvent getOne(Long id) {
        return this.mapper.selectById(id);
    }
}
