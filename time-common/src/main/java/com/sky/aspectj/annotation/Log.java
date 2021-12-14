package com.sky.aspectj.annotation;

import com.sky.aspectj.enums.BusinessType;
import com.sky.aspectj.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * @author sky
 * @create 2021-12-14 10:40
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人员
     */
    OperatorType operatorType() default OperatorType.ADMIN;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;
}
