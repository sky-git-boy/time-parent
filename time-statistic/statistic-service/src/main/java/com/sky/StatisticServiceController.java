package com.sky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sky
 * @create 2021-12-23 10:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class StatisticServiceController {
    public static void main(String[] args) {
        SpringApplication.run(StatisticServiceController.class, args);
        System.out.println("统计模块 启动成功\n");
    }
}
