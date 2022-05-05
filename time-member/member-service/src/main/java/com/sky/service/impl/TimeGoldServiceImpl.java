package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sky.domain.TimeGold;
import com.sky.dto.TimeGoldDTO;
import com.sky.mapper.TimeGoldMapper;
import com.sky.service.TimeGoldService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sky
 * @create 2021-12-15 10:32
 */
@Service
public class TimeGoldServiceImpl implements TimeGoldService {

    @Autowired
    private TimeGoldMapper mapper;

    @Override
    public TimeGold getOne(Long userId) {
        return this.mapper.selectOne(
                new LambdaQueryWrapper<TimeGold>()
                        .eq(TimeGold::getUserId, userId)
        );
    }

    @Override
    public int update(TimeGoldDTO dto) {
        TimeGold bean = new TimeGold();
        bean.setGoldId(dto.getGoldId());
        bean.setDataJson(dto.getDataJson());
        return this.mapper.updateById(bean);
    }

    @Override
    public int insert(TimeGoldDTO dto) {
        TimeGold bean = new TimeGold();
        BeanUtils.copyProperties(dto, bean);
        bean.setCreateTime(new Date());
        bean.setUserId(dto.getSimpleUser().getUserId());
        return this.mapper.insert(bean);
    }


}
