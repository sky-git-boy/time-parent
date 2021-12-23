package com.sky.service.impl;

import com.sky.dto.AllCountDTO;
import com.sky.dto.LineChartDTO;
import com.sky.mapper.LogSmsInfoMapper;
import com.sky.service.AdminStatService;
import com.sky.service.LogOperInfoService;
import com.sky.service.LogSmsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @create 2021-12-23 10:26
 */
@Service
public class AdminStatServiceImpl implements AdminStatService {

    @Autowired
    private LogOperInfoService logOperInfoService;

    @Autowired
    private LogSmsInfoService logSmsInfoService;

    @Autowired
    private LogSmsInfoMapper logSmsInfoMapper;

    @Override
    public LineChartDTO lineChart() {
        LineChartDTO dto = new LineChartDTO();
        String[] days = dto.getDays();
        int[] loginCount = dto.getLoginCount();
        int[] smsCount = dto.getSmsCount();
        logOperInfoService.getDataDays().forEach(s -> {
            for (int i=0; i<days.length; i++) {
                if (days[i].equals(s.getDays())) {
                    loginCount[i] = s.getCount();
                    break;
                }
            }
        });
        logSmsInfoService.getDataDays().forEach(s -> {
            for (int i=0; i<days.length; i++) {
                if (days[i].equals(s.getDays())) {
                    smsCount[i] = s.getCount();
                    break;
                }
            }
        });
        return dto;
    }

    @Override
    public AllCountDTO getAllCount() {
        AllCountDTO dto = new AllCountDTO();
        Long loginCount = logOperInfoService.getLoginCount();
        Long smsCount = logSmsInfoService.getSmsCount();
        dto.setUserLoginCount(loginCount);
        dto.setSmsCount(smsCount);
        dto.setTaskCount(logSmsInfoMapper.getTaskCount());
        dto.setEvenCount(logSmsInfoMapper.getEventCount());
        dto.setJournalCount(logSmsInfoMapper.getJournalCount());
        dto.setNoticeCount(logSmsInfoMapper.getNoticeCount());
        dto.setMusicCount(logSmsInfoMapper.getMusicCount());
        dto.setUserCount(logSmsInfoMapper.getUserCount());
        dto.setSlideCount(logSmsInfoMapper.getSlideCount());
        return dto;
    }
}
