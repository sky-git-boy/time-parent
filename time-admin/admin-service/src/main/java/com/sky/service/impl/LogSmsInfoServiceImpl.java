package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.dto.LogSmsInfoDTO;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.domain.LogSmsInfo;
import com.sky.mapper.LogSmsInfoMapper;
import com.sky.service.LogSmsInfoService;

import java.util.Arrays;

/**
 * @author sky
 * @create 2021-11-30 9:41
 */
@Service
public class LogSmsInfoServiceImpl implements LogSmsInfoService {

    @Autowired
    private LogSmsInfoMapper smsInfoMapper;

    @Override
    public DataGridView listSmsPage(LogSmsInfoDTO smsDto) {
        Page<LogSmsInfo> page = new Page<>(smsDto.getPageNum(), smsDto.getPageSize());
        QueryWrapper<LogSmsInfo> qw = new QueryWrapper<>();
        // 查询条件
        qw.like(StringUtils.isNotBlank(smsDto.getMobile()), LogSmsInfo.COL_MOBILE, smsDto.getMobile());
        qw.eq(StringUtils.isNotBlank(smsDto.getStatus()), LogSmsInfo.COL_STATUS, smsDto.getStatus());
        qw.ge(null != smsDto.getBeginTime(), LogSmsInfo.COL_CREATE_TIME, smsDto.getBeginTime());
        qw.le(null != smsDto.getEndTime(), LogSmsInfo.COL_CREATE_TIME, smsDto.getEndTime());
        qw.orderByDesc(LogSmsInfo.COL_CREATE_TIME);
        this.smsInfoMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public LogSmsInfo getById(Long id) {
        return this.smsInfoMapper.selectById(id);
    }

    @Override
    public int deleteSmsByIds(Long[] ids) {
        if (ids != null && ids.length > 0) {
            return this.smsInfoMapper.deleteBatchIds(Arrays.asList(ids));
        }
        return 0;
    }
}
