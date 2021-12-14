package com.sky.aspectj;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.sky.aspectj.annotation.Log;
import com.sky.aspectj.enums.BusinessStatus;
import com.sky.domain.LogOperInfo;
import com.sky.domain.SimpleUser;
import com.sky.service.LogOperInfoService;
import com.sky.utils.AddressUtils;
import com.sky.utils.IpUtils;
import com.sky.utils.SecurityUtils;
import com.sky.utils.ServletUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 操作日志记录处理
 * 切面类用来记录操作日志
 * @author sky
 * @create 2021-12-14 10:46
 */
@Aspect
@Component
@Log4j2
public class OperLogAspect {
    @Autowired
    private LogOperInfoService service;

    /**
     * 声明切面
     * 只要 Controller的方法里面有 @Log 这个注解，那我就进行切入
     */
    @Pointcut("@annotation(com.sky.aspectj.annotation.Log)")
    public void logPointCut(){}

    /**
     * 处理完请求后执行
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void afterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常处理
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {
            Log log = getAnnotationLog(joinPoint);
            if (log == null) {
                return ;
            }

            // 获取当前用户
            SimpleUser user = SecurityUtils.getUser();

            // 数据库日志
            LogOperInfo logOperInfo = new LogOperInfo();
            logOperInfo.setStatus(String.valueOf(BusinessStatus.SUCCESS.ordinal()));
            // 请求的地址
            String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
            logOperInfo.setOperIp(ip);
            String address = AddressUtils.getRealAddressByIP(ip);
            logOperInfo.setOperLocation(address);

            // 返回参数
            logOperInfo.setJsonResult(JSON.toJSONString(jsonResult));
            logOperInfo.setOperUrl(ServletUtils.getRequest().getRequestURI());

            // 操作人Id
            if (null != user.getUserId()) {
                logOperInfo.setOperBy(user.getUserId());
            }

            if (e != null) {
                logOperInfo.setStatus(String.valueOf(BusinessStatus.FAIL.ordinal()));
                logOperInfo.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }

            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            logOperInfo.setMethod(className + "." + methodName + "()");
            // 设置请求方式
            logOperInfo.setRequestMethod(ServletUtils.getRequest().getMethod());
            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, log, logOperInfo);
            //设置操作时间
            logOperInfo.setOperTime(DateUtil.date());
            // 保存数据库
            service.save(logOperInfo);
        } catch (Exception ex) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }

    /**
     * 获取注解中对方法的描述信息 用于 Controller 层注解
     */
    private void getControllerMethodDescription(JoinPoint joinPoint, Log log, LogOperInfo logOperInfo) {
        // 设置action动作
        logOperInfo.setBusinessType(String.valueOf(log.businessType().ordinal()));
        // 设置标题
        logOperInfo.setTitle(log.title());
        // 设置操作人类别
        logOperInfo.setOperatorType(log.operatorType().ordinal() + "");
        // 是否需要保存request，参数和值
        if (log.isSaveRequestData()) {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(joinPoint, logOperInfo);
        }
    }

    /**
     * 获取请求的参数，放到 log 中
     */
    private void setRequestValue(JoinPoint joinPoint, LogOperInfo logOperInfo) {
        String requestMethod = logOperInfo.getRequestMethod();
        if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)) {
            String params = argsArrayToString(joinPoint.getArgs());
            logOperInfo.setOperParam(StringUtils.substring(params, 0, 2000));
        } else {
            Map<?, ?> paramsMap = (Map<?, ?>) ServletUtils.getRequest().getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            logOperInfo.setOperParam(StringUtils.substring(paramsMap.toString(), 0, 2000));
        }
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray) {
        StringBuilder params = new StringBuilder();
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (!isFilterObject(o)) {
                    Object jsonObj = JSON.toJSON(o);
                    params.append(jsonObj.toString()).append(" ");
                }
            }
        }
        return params.toString().trim();
    }

    /**
     * 判断是否需要过滤的对象。
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    public boolean isFilterObject(final Object o) {
        return o instanceof MultipartFile || o instanceof HttpServletRequest
                || o instanceof HttpServletResponse;
    }
}
