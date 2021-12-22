package com.sky.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.sky.constants.Constants;
import com.sky.domain.LogSmsInfo;
import com.sky.service.LogSmsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 发送验证码工具类
 *
 * @author sky
 * @create 2021-12-22 14:34
 */
@Component
public class TsmsUtil {

    @Value("${tencent.appid}")
    private int appid;

    @Value("${tencent.appkey}")
    private String appkey;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private LogSmsInfoService smsInfoService;

    public String sendSMS(String phone, boolean flag) {
        String reStr = ""; // 定义返回值
        String smsSign = "垃圾分类sky";
        String code = RandomUtil.randomNumbers(4);
        try {
            // 参数，一定要对应短信模板中的参数顺序和个数，
            String[] params = {code, String.valueOf(Constants.CAPTCHA_EXPIRATION)};
            // 创建ssender对象
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);

            int templateId;
            if (flag)
                templateId = 1195405; // 注册
            else
                templateId = 1251195; // 重置密码

            // 发送
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone, templateId, params, smsSign, "", "");

            // 构造短信发送记录对象
            LogSmsInfo sysSmsLog = new LogSmsInfo();
            sysSmsLog.setId(IdGeneratorSnowflake.snowflakeId());
            sysSmsLog.setMobile(phone);
            sysSmsLog.setCode(code);

            if (flag)
                sysSmsLog.setType(Constants.UNIQUE); // 注册验证码
            else
                sysSmsLog.setType(Constants.NOT_UNIQUE);

            sysSmsLog.setCreateTime(DateUtil.date());

            // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result.toString());

            if (result.result == 0) {
                reStr = "success";
                sysSmsLog.setStatus(Constants.STATUS_TRUE);
            } else {
                reStr = "error";
                sysSmsLog.setStatus(Constants.STATUS_FALSE);
                sysSmsLog.setErrorInfo("error");
            }

            this.smsInfoService.insertSms(sysSmsLog);

            // 将验证码存入 redis 中，设置过期时间 2分钟
            redisTemplate.opsForValue().set(Constants.REDIS_KEY_SMS_CODE_KEY + phone, code,
                    Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reStr;
    }
}
