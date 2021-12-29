package com.sky.controller;

import com.sky.service.TimeOrderService;
import io.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sky
 * @create 2021-12-29 16:07
 */
@RestController
@Api("用户支付控制器")
@RequestMapping("pay")
public class PayController {


    @Autowired
    private TimeOrderService orderService;

    @RequestMapping("callback")
    @Transactional
    public void callback(String orderId, HttpServletRequest request) {

        // 设置订单状态为已支付
        int pay = orderService.pay(orderId);

    }

}
