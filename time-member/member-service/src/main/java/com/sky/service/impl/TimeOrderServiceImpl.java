package com.sky.service.impl;

import com.sky.constants.Constants;
import com.sky.dto.TimeOrderDTO;
import com.sky.feign.UserServiceFeign;
import com.sky.utils.IdGeneratorSnowflake;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.domain.TimeOrder;
import com.sky.mapper.TimeOrderMapper;
import com.sky.service.TimeOrderService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sky
 * @create 2021-12-29 16:37
 */
@Service
public class TimeOrderServiceImpl implements TimeOrderService {

    @Autowired
    private TimeOrderMapper orderMapper;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public Long createOrder(TimeOrderDTO orderDTO) {
        TimeOrder order = new TimeOrder();
        BeanUtils.copyProperties(orderDTO, order);
        order.setCreateTime(new Date());
        order.setOrderId(IdGeneratorSnowflake.snowflakeId());
        order.setOrderStatus(Constants.ORDER_STATUS_0); // 未支付

        int insert = this.orderMapper.insert(order);

        return insert > 0 ? order.getOrderId() : null;
    }

    @Override
    @Transactional
    public int pay(String orderId) {
        TimeOrder order = this.orderMapper.selectById(orderId);
        order.setOrderStatus(Constants.ORDER_STATUS_1);
        order.setPayTime(new Date());
        int i = this.orderMapper.updateById(order);
        if (i > 0) {
            try {
                userServiceFeign.plusUser(order.getUserId(), order.getOrderItem());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override
    public TimeOrder getOne(Long orderId) {
        return this.orderMapper.selectById(orderId);
    }
}
