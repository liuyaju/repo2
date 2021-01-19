package com.yousian;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.yousian.dao")
@EnableDiscoveryClient
public class PaymentApplication4 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication4.class,args);
    }

}
