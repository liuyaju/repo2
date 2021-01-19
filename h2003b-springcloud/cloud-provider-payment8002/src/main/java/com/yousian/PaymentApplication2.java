package com.yousian;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yousian.dao")
public class PaymentApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication2.class,args);
    }

}
