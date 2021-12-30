package com.sky.pay;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付服务
 *
 * @author sky
 * @create 2021-12-29 11:58
 */
@Log4j2
public class PayService {
    //支付定当关付的对象
    static AlipayTradeService tradeService;

    //初始化对象
    static {
        // 一定要在创建AlipayTradeService之前设置参数
        Configs.init("zfbinfo.properties");
        tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
    }

    // 商户操作员编号，添加此参数可以为商户操作员做销售统计
    static String operatorId = "test_operator_id";

    // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
    static String storeId = "test_store_id";

    // 支付超时，定义为120分钟
    static String timeoutExpress = "120m";

    /**
     * 支付的方法
     *
     * @param outTradeNo           (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线， 需保证商户系统端不能重复，建议通过数据库sequence生成，
     * @param subject              (必填) 订单标题，粗略描述用户的支付目的。如“喜士多（浦东店）消费”
     * @param totalAmount          (必填) 订单总金额，单位为元，不能超过1亿元
     * @param undiscountableAmount (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
     * @param body                 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
     * @param notifyUrl            支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
     */
    public static Map<String, Object> pay(
            String outTradeNo,
            String subject,
            String totalAmount,
            String undiscountableAmount,
            String body,
            String notifyUrl) {
        System.out.println(notifyUrl);
        AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
                .setSubject(subject)
                .setTotalAmount(totalAmount)
                .setOutTradeNo(outTradeNo)
                .setUndiscountableAmount(undiscountableAmount)
                .setBody(body)
                .setOperatorId(operatorId)
                .setStoreId(storeId)
                .setTimeoutExpress(timeoutExpress)
                .setNotifyUrl(notifyUrl);
        //发起支付
        AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
        Map<String, Object> map = new HashMap<>();
        String msg;
        int code;
        switch (result.getTradeStatus()) {
            case SUCCESS:
                log.info("支付宝预下单成功: )");
                AlipayTradePrecreateResponse res = result.getResponse();
                // 得到支付码,本质就是一个URL
                String qrCode = res.getQrCode();
                map.put("qrCode", qrCode);
                msg = "下单成功";
                code = 200;
                break;
            case FAILED:
                log.error("支付宝预下单失败!!!");
                msg = "下单失败";
                code = 500;
                break;
            case UNKNOWN:
                log.error("系统异常，预下单状态未知!!!");
                msg = "系统异常";
                code = 404;
                break;
            default:
                log.error("不支持的交易状态，交易返回异常!!!");
                msg = "不支持的交易状态";
                code = 404;
                break;
        }
        map.put("msg", msg);
        map.put("code", code);
        return map;
    }
}
