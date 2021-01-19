package com.yousian.impl;

import com.yousian.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class FallBackService implements OrderService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "进行paymentInfo_OK 方法降级处理。。。";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "进行payment_Timeout 方法降级处理。。。";
    }
}
