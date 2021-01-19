package com.yousian.dao;

import com.yousian.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {
    //新增订单
    public int create(Payment payment);

    //根据id查询订单信息
    public Payment getPaymentById(@Param("id") Long id);
}
