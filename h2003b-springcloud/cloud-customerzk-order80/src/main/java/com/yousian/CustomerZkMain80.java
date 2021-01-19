package com.yousian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(CustomerZkMain80.class,args);
    }

}
