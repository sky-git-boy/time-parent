package com.sky.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.dto.LogOperInfoDTO;
import com.sky.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.mapper.LogOperInfoMapper;
import com.sky.domain.LogOperInfo;
import com.sky.service.LogOperInfoService;

/**
 * @author sky
 * @create 2021-12-14 10:50
 */
@Service
public class LogOperInfoServiceImpl extends ServiceImpl<LogOperInfoMapper, LogOperInfo> implements LogOperInfoService {
    @Autowired
    private LogOperInfoMapper operInfoMapper;

    @Override
    public DataGridView listForPage(LogOperInfoDTO operLogDto) {
        QueryWrapper<LogOperInfo> qw = new QueryWrapper<>();
        Page<LogOperInfo> page = new Page<>(operLogDto.getPageNum(), operLogDto.getPageSize());
        qw.like(null != operLogDto.getOperBy(), LogOperInfo.COL_OPER_BY, operLogDto.getOperBy());
        qw.like(StringUtils.isNotBlank(operLogDto.getTitle()), LogOperInfo.COL_TITLE, operLogDto.getTitle());
        qw.eq(StringUtils.isNotBlank(operLogDto.getBusinessType()), LogOperInfo.COL_BUSINESS_TYPE, operLogDto.getBusinessType());
        qw.eq(StringUtils.isNotBlank(operLogDto.getStatus()), LogOperInfo.COL_STATUS, operLogDto.getStatus());
        qw.ge(null != operLogDto.getBeginTime(), LogOperInfo.COL_OPER_TIME, operLogDto.getBeginTime());
        qw.le(null != operLogDto.getEndTime(), LogOperInfo.COL_OPER_TIME, operLogDto.getEndTime());
        qw.orderByDesc(LogOperInfo.COL_OPER_TIME);
        this.operInfoMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public int deleteOperLogByIds(Long[] infoIds) {
        if(infoIds != null && infoIds.length > 0) {
            return this.operInfoMapper.deleteBatchIds(Arrays.asList(infoIds));
        }
        return 0;
    }

    @Override
    public int clearAllOperLog() {
        return this.operInfoMapper.delete(null);
    }

    @Override
    public int insertOperLog(LogOperInfo operLog) {
        return this.operInfoMapper.insert(operLog);
    }
}
