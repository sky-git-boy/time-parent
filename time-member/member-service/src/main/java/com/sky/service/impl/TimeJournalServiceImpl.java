package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.domain.TimeJournal;
import com.sky.dto.TimeJournalDTO;
import com.sky.mapper.TimeJournalMapper;
import com.sky.service.TimeJournalService;
import com.sky.utils.IdGeneratorSnowflake;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sky
 * @create 2021-12-03 11:51
 */
@Service
public class TimeJournalServiceImpl implements TimeJournalService {

    @Autowired
    private TimeJournalMapper mapper;

    @Override
    public int add(TimeJournalDTO dto) {
        TimeJournal bean = new TimeJournal();
        BeanUtils.copyProperties(dto, bean);
        bean.setRecordId(IdGeneratorSnowflake.snowflakeId());
        bean.setUserId(dto.getSimpleUser().getUserId());
        bean.setCreateTime(new Date());
        return this.mapper.insert(bean);
    }

    @Override
    public int update(TimeJournalDTO dto) {
        TimeJournal bean = new TimeJournal();
        BeanUtils.copyProperties(dto, bean);
        bean.setUpdateTime(new Date());
        return this.mapper.updateById(bean);
    }

    @Override
    public DataGridView listPage(TimeJournalDTO dto) {
        Page<TimeJournal> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        QueryWrapper<TimeJournal> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotEmpty(dto.getTitle()), TimeJournal.COL_TITLE, dto.getTitle())
                .or()
                .like(StringUtils.isNotEmpty(dto.getTitle()), TimeJournal.COL_DESCRIPTION, dto.getTitle());
        qw.eq(TimeJournal.COL_USER_ID, dto.getSimpleUser().getUserId());
        qw.orderByDesc(TimeJournal.COL_CREATE_TIME);
        this.mapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public TimeJournal getOne(String recordId) {
        return this.mapper.selectById(recordId);
    }


}
