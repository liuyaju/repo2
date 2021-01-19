package com.yousian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yousian.dao")
public class ConsulServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceApplication.class,args);
    }
}
