package com.sky.service.impl;

import com.sky.constants.Constants;
import com.sky.dto.AllCountDTO;
import com.sky.dto.BaseDTO;
import com.sky.dto.LineChartDTO;
import com.sky.dto.OrderStatDTO;
import com.sky.mapper.LogSmsInfoMapper;
import com.sky.service.AdminStatService;
import com.sky.service.LogOperInfoService;
import com.sky.service.LogSmsInfoService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        int loginCount = logOperInfoService.getLoginCount();
        int smsCount = logSmsInfoService.getSmsCount();
        dto.setUserLoginCount(loginCount);
        dto.setSmsCount(smsCount);
        dto.setUserCount(logSmsInfoMapper.getUserCount());
        dto.setOperCount(logSmsInfoMapper.getOperCount());
        return dto;
    }

    @Override
    public AllCountDTO pieChart() {
        AllCountDTO dto = new AllCountDTO();
        dto.setTaskCount(logSmsInfoMapper.getTaskCount());
        dto.setEvenCount(logSmsInfoMapper.getEventCount());
        dto.setJournalCount(logSmsInfoMapper.getJournalCount());
        return dto;
    }

    @Override
    public AllCountDTO systemChart() {
        AllCountDTO dto = new AllCountDTO();
        dto.setNoticeCount(logSmsInfoMapper.getNoticeCount());
        dto.setMusicCount(logSmsInfoMapper.getMusicCount());
        dto.setUserCount(logSmsInfoMapper.getUserCount());
        dto.setSlideCount(logSmsInfoMapper.getSlideCount());
        return dto;
    }

    @Override
    public LineChartDTO barChart() {
        LineChartDTO dto = new LineChartDTO();
        String[] days = dto.getDays();
        int[] operCount = dto.getOperCount();
        logOperInfoService.getOperDataDays().forEach(s -> {
            for (int i=0; i<days.length; i++) {
                if (days[i].equals(s.getDays())) {
                    operCount[i] = s.getCount();
                    break;
                }
            }
        });
        return dto;
    }

    @Override
    public List<OrderStatDTO> orderStatusChart(BaseDTO dto) {
        // 时间格式化
        formatDate(dto);

        List<OrderStatDTO> res = new ArrayList<>();
        // 获取订单状态统计
        this.logSmsInfoMapper.getOrderStatusCount(dto).forEach(s -> {
            OrderStatDTO statDTO = new OrderStatDTO();
            statDTO.setValue(s.getCount());
            switch (s.getDays()) {
                case Constants.ORDER_STATUS_0:
                    statDTO.setName("未支付");
                    break;
                case Constants.ORDER_STATUS_1:
                    statDTO.setName("已支付");
                    break;
                case Constants.ORDER_STATUS_2:
                    statDTO.setName("支付超时");
                    break;
                case Constants.ORDER_STATUS_3:
                    statDTO.setName("支付失败");
                    break;
            }
            res.add(statDTO);
        });
        if (res.isEmpty()) {
            res.add(new OrderStatDTO("未支付", 0));
            res.add(new OrderStatDTO("已支付", 0));
        }
        return res;
    }

    @Override
    public List<OrderStatDTO> orderTypeChart(BaseDTO dto) {
        // 时间格式化
        formatDate(dto);

        List<OrderStatDTO> res = new ArrayList<>();
        // 获取订单状态统计
        this.logSmsInfoMapper.getOrderTypeCount(dto).forEach(s -> {
            OrderStatDTO statDTO = new OrderStatDTO();
            System.out.println(s);
            statDTO.setValue(s.getCount());
            switch (s.getDays()) {
                case Constants.ORDER_TYPE_0:
                    statDTO.setName("一个月");
                    break;
                case Constants.ORDER_TYPE_1:
                    statDTO.setName("半年");
                    break;
                case Constants.ORDER_TYPE_2:
                    statDTO.setName("一年");
                    break;
                case Constants.ORDER_TYPE_3:
                    statDTO.setName("永久");
                    break;
            }
            res.add(statDTO);
        });
        if (res.isEmpty()) {
            res.add(new OrderStatDTO("一个月", 0));
            res.add(new OrderStatDTO("半年", 0));
            res.add(new OrderStatDTO("一年", 0));
            res.add(new OrderStatDTO("永久", 0));
        }
        return res;
    }

    @Override
    public int orderCount(BaseDTO dto) {
        // 时间格式化
        formatDate(dto);
        Integer count = this.logSmsInfoMapper.getOrderCount(dto);
        return count == null ? 0 : count;
    }

    private void formatDate(BaseDTO dto) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = null;
        Date endTime = null;
        if (dto.getBeginTime() == null && dto.getEndTime() == null) {
            String now = format.format(new Date());
            String beginDate = now + " 00:00:00";
            String endDate = now + " 23:59:59";
            try {
                beginTime = dateFormat.parse(beginDate);
                endTime = dateFormat.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            String beginDate = format.format(dto.getBeginTime()) + " 00:00:00";
            String endDate = format.format(dto.getEndTime()) + " 23:59:59";
            try {
                beginTime = dateFormat.parse(beginDate);
                endTime = dateFormat.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        dto.setBeginTime(beginTime);
        dto.setEndTime(endTime);
    }
}
