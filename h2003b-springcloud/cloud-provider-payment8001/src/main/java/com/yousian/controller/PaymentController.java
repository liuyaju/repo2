package com.yousian.controller;

import com.yousian.pojo.CommonResult;
import com.yousian.pojo.Payment;
import com.yousian.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
@EnableEurekaClient//表示eureka客户端
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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
            return new CommonResult(200,"查询成功1",payment);
        }else {
            return new CommonResult(500,"查询失败",null);
        }

    }

    @GetMapping("/customer/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info("service:"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance instance : instances){
            String host = instance.getHost();
            int port = instance.getPort();
            String serviceId = instance.getServiceId();
            log.info("host:" + host + "port:" + port + "serviceId:" + serviceId);
        }
        return this.discoveryClient;
    }

    //故意模拟服务超时
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "aoligei...";
    }

}
