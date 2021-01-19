package com.yousian.controller;

import com.yousian.pojo.CommonResult;
import com.yousian.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CustomerConsulController {

    public static final String URL = "http://consul-provider-service";

    @Resource
    RestTemplate restTemplate;

    //调用服务提供方   查询订单信息的方法
    @GetMapping("/customer/payment/{id}")
    public CommonResult<Payment> findOrderById(@PathVariable("id") Long id){
        CommonResult commonResult = restTemplate.getForObject(URL + "/payment/" + id, CommonResult.class);
        return commonResult;
    }


}
