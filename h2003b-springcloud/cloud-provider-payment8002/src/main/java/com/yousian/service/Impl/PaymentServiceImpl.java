package com.yousian.service.Impl;

import com.yousian.dao.PaymentDao;
import com.yousian.pojo.Payment;
import com.yousian.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@SuppressWarnings("all")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentdao;

    @Override
    public int create(Payment payment) {
        return paymentdao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentdao.getPaymentById(id);
    }
}
