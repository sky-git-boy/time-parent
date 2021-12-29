package com.sky.service;

import com.sky.domain.TimeOrder;
import com.sky.dto.TimeOrderDTO;
import com.sky.vo.R;

/**
 * @author sky
 * @create 2021-12-29 16:37
 */
public interface TimeOrderService {

    // 创建订单
    Long createOrder(TimeOrderDTO orderDTO);

    // 修改订单状态
    int pay(String orderId);

    // 获取订单
    TimeOrder getOne(Long orderId);
}
