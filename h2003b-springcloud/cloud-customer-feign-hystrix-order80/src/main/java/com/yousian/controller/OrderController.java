package com.yousian.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yousian.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalHandler")//开启全局降级逻辑处理
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/consumer/payment/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        log.info("paymentInfo_OK");
        return orderService.paymentInfo_OK(id);
    }

//    @HystrixCommand //不写注解的fallbackmethod属性 就使用全局的
    @GetMapping("/consumer/payment/timeout/hystrix/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        log.info("paymentInfo_Timeout");
        return orderService.paymentInfo_Timeout(id);
    }

//    //全局降级处理方法
//    public String globalHandler(){
//        return "全局处理方法。。。";
//    }










//       @HystrixCommand(fallbackMethod = "handeException", commandProperties = {
//            //设置峰值，超过 1.5 秒，就会调用兜底方法
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })


//    public String handeException(Integer id) {
//        return "服务调用异常，请稍后再试.....";
//    }



}
