package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.domain.TimeGold;
import com.sky.dto.TimeGoldDTO;
import com.sky.mapper.TimeGoldMapper;
import com.sky.service.TimeGoldService;
import com.sky.utils.IdGeneratorSnowflake;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @create 2021-12-15 10:32
 */
@Service
public class TimeGoldServiceImpl implements TimeGoldService {

    @Autowired
    private TimeGoldMapper mapper;

    @Override
    public DataGridView list(TimeGoldDTO dto) {
        Page<TimeGold> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        QueryWrapper<TimeGold> qw = new QueryWrapper<>();
        qw.eq(StringUtils.isNotEmpty(dto.getStatus()), TimeGold.COL_STATUS, dto.getStatus());
        qw.eq(TimeGold.COL_USER_ID, dto.getSimpleUser().getUserId());
        this.mapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int saveOrUpdate(TimeGoldDTO dto, Long userId) {
        TimeGold bean = new TimeGold();
        BeanUtils.copyProperties(dto, bean);
        int flag;
        if (null == bean.getGoldId()) { // 新增
            bean.setGoldId(IdGeneratorSnowflake.snowflakeId());
            bean.setUserId(userId);
            flag = this.mapper.insert(bean);
        } else { // 修改
            flag = this.mapper.updateById(bean);
        }
        return flag;
    }

    @Override
    public int delete(Long id) {
        return this.mapper.deleteById(id);
    }

    @Override
    public TimeGoldDTO getOne(Long id) {
        TimeGold gold = this.mapper.selectById(id);
        TimeGoldDTO dto = new TimeGoldDTO();
        BeanUtils.copyProperties(dto, gold);
        return dto;
    }
}
