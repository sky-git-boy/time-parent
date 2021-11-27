package com.sky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权服务器启动类
 *
 * @author sky
 * @create 2021-11-19 9:59
 */
@SpringBootApplication
public class AuthorizationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
        System.out.println("授权服务 启动成功\n");
    }
}
