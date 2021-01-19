package com.yousian.controller;

import com.yousian.pojo.CommonResult;
import com.yousian.pojo.Payment;
import com.yousian.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        System.out.println(payment);
        int result = paymentService.create(payment);
        if(result>0){
            //如果sesult大于0证明添加成功
            return new CommonResult(200,"添加数据成功",result);
        }else{
            //添加失败
            return new CommonResult(500,"添加数据失败",null);
        }

    }


    @GetMapping("payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(500,"查询失败",null);
        }

    }



}
