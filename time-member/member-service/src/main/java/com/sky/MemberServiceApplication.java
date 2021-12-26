package com.sky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author sky
 * @create 2021-12-01 17:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableFeignClients
public class MemberServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class, args);
        System.out.println("前台系统 启动成功\n");
    }
}
