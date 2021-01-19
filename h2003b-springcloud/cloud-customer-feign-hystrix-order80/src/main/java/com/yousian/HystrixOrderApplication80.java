package com.yousian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启feign客户端
@EnableCircuitBreaker//开启熔断器
public class HystrixOrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication80.class,args);
    }
}
