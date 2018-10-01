package com.example.springboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//激活eureka中的 DiscoveryClient实现 自动化配置 记该应用注册成为Eureka客户端应用
public class SpringbootHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloApplication.class, args);
    }
}
