package com.yousian.controller;

import com.yousian.pojo.CommonResult;
import com.yousian.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@EnableEurekaClient
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    public static final String URL = "http://cloud-payment-service";

    //调用服务提供方   查询订单信息的方法
    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> findOrderById(@PathVariable("id") Long id){
        CommonResult commonResult = restTemplate.getForObject(URL + "/payment/" + id, CommonResult.class);
        return commonResult;
    }

    //调用服务提供反  进行添加订单操作
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        CommonResult commonResult = restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
        return commonResult;
    }

}
