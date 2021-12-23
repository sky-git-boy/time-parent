package com.sky.service.impl;

import com.sky.domain.SimpleUser;
import com.sky.dto.*;
import com.sky.exception.BusinessException;
import com.sky.mapper.LogOperInfoMapper;
import com.sky.service.MemberStatService;
import com.sky.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sky
 * @create 2021-12-23 15:10
 */
@Service
public class MemberStatServiceImpl implements MemberStatService {

    @Autowired
    private LogOperInfoMapper mapper;

    @Override
    public PieChartDTO pieChart() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        List<DataDTO> list = this.mapper.getPieChartDTO(user.getUserId());
        PieChartDTO dto = new PieChartDTO();
        int[] statusCount = dto.getStatusCount();
        list.forEach(l -> statusCount[Integer.parseInt(l.getDays())] = l.getCount());
        return dto;
    }

    @Override
    public LineChartSimpleDTO lineChartSimple() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        LineChartSimpleDTO dto = new LineChartSimpleDTO();
        String[] days = dto.getDays();
        int[] count = dto.getCount();
        this.mapper.lineChartSimple(user.getUserId()).forEach(s -> {
            for (int i=0; i<days.length; i++) {
                if (days[i].equals(s.getDays())) {
                    count[i] = s.getCount();
                    break;
                }
            }
        });
        return dto;
    }

    @Override
    public ColumnChartDTO columnChart() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        ColumnChartDTO dto = new ColumnChartDTO();
        int[] count = dto.getCount();
        String[] days = dto.getDays();
        this.mapper.columnChart(user.getUserId()).forEach(s -> {
            for (int i=0; i<days.length; i++) {
                if (days[i].equals(s.getDays())) {
                    count[i] = s.getCount();
                    break;
                }
            }
        });
        return dto;
    }

    @Override
    public MixedChartDTO mixChart() {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        Long userId = user.getUserId();

        MixedChartDTO dto = new MixedChartDTO();
        String[] months = dto.getMonths();
        int[] taskCountM = dto.getTaskCountM();
        int[] eventCountM = dto.getEventCountM();
        int[] journalCountM = dto.getJournalCountM();
        this.mapper.getTaskCountEachMonth(userId).forEach(s -> {
            for (int i=0; i<months.length; i++) {
                if (months[i].equals(s.getDays())) {
                    taskCountM[i] = s.getCount();
                    break;
                }
            }
        });
        this.mapper.getEventCountEachMonth(userId).forEach(s -> {
            for (int i=0; i<months.length; i++) {
                if (months[i].equals(s.getDays())) {
                    eventCountM[i] = s.getCount();
                    break;
                }
            }
        });
        this.mapper.getJournalCountEachMonth(userId).forEach(s -> {
            for (int i=0; i<months.length; i++) {
                if (months[i].equals(s.getDays())) {
                    journalCountM[i] = s.getCount();
                    break;
                }
            }
        });
        return dto;
    }
}
