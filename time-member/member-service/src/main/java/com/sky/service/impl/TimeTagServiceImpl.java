package com.sky.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.domain.TimeTag;
import com.sky.dto.TimeTagDTO;
import com.sky.mapper.TimeTagMapper;
import com.sky.service.TimeTagService;
import com.sky.utils.IdGeneratorSnowflake;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @create 2021-12-03 18:09
 */
@Service
public class TimeTagServiceImpl implements TimeTagService {

    @Autowired
    private TimeTagMapper mapper;

    @Override
    public List<TimeTagDTO> list(Long userId) {
        List<TimeTagDTO> res = new ArrayList<>();
        this.mapper.selectList(
                new LambdaQueryWrapper<TimeTag>().eq(TimeTag::getUserId, userId)
        ).forEach(s -> {
            TimeTagDTO dto = new TimeTagDTO();
            BeanUtils.copyProperties(s, dto);
            res.add(dto);
        });
        return res;
    }

    @Override
    public int saveOrUpdate(TimeTagDTO dto, Long userId) {
        TimeTag tag = new TimeTag();
        BeanUtils.copyProperties(dto, tag);
        int flag;
        if (null == tag.getTagId()) { // 新增
            tag.setTagId(IdGeneratorSnowflake.snowflakeId());
            tag.setUserId(userId);
            tag.setCreateTime(new Date());
            flag = this.mapper.insert(tag);
        } else { //修改
            tag.setUpdateTime(new Date());
            flag = this.mapper.updateById(tag);
        }
        return flag;
    }

    @Override
    public int delete(Long id) {
        return this.mapper.deleteById(id);
    }

    @Override
    public TimeTag getOne(Long id) {
        return this.mapper.selectById(id);
    }
}
