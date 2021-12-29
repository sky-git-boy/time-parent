package com.sky.controller;

import com.sky.config.AlipayConfig;
import com.sky.domain.SimpleUser;
import com.sky.dto.TimeOrderDTO;
import com.sky.exception.BusinessException;
import com.sky.pay.PayService;
import com.sky.service.TimeOrderService;
import com.sky.utils.SecurityUtils;
import com.sky.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sky
 * @create 2021-12-29 16:38
 */
@RestController
@Api("订单控制器")
@RequestMapping("order")
public class OrderController {

    @Autowired
    private TimeOrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping("createOrder")
    public R createOrder(@RequestBody TimeOrderDTO orderDTO) {
        SimpleUser user = SecurityUtils.getUser();
        if (null == user.getUserId()) {
            throw new BusinessException("获取用户信息失败");
        }
        orderDTO.setUserId(user.getUserId());
        // 创建订单
        Long orderId = this.orderService.createOrder(orderDTO);

        // 调用支付宝接口，返回二维码
        String outTradeNo = orderId.toString();
        String subject = "时间轮支付平台";
        String totalAmount = orderDTO.getOrderAmount().toString();
        String body = "会员升级";
        String notifyUrl = AlipayConfig.notifyUrl + "?orderId=" + orderId;
        Map<String, Object> pay = PayService.pay(outTradeNo, subject, totalAmount, null, body, notifyUrl);
        String qrCode = pay.get("qrCode").toString();
        if (StringUtils.isNotBlank(qrCode)) {
            //创建支付成功
            Map<String, Object> map = new HashMap<>();
            map.put("orderId", orderId);
            map.put("payUrl", qrCode);
            return R.success(map);
        } else {
            return R.fail(pay.get("msg").toString());
        }
    }

    @ApiOperation("获取订单")
    @GetMapping("getOrder")
    public R queryOrderById(Long orderId) {
        return R.success(this.orderService.getOne(orderId));
    }
}
