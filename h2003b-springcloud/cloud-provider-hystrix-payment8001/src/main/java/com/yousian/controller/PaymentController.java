package com.yousian.controller;

import com.yousian.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    //正常访问的方法
    @GetMapping("/payment/hystrix/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        log.info("paymentInfo_OK");
        return paymentService.paymentInfo_ok(id);
    }

    //超时访问的方法
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo(@PathVariable("id")Integer id){
        log.info("paymentInfo_Timeout");
        return paymentService.paymentInfo_Timeout(id);
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCiruitBreaker(@PathVariable("id")Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }


}
