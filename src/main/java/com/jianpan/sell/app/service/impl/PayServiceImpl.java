package com.jianpan.sell.app.service.impl;

import com.jianpan.sell.app.dto.OrderDTO;
import com.jianpan.sell.app.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {


    @Override
    public PayResponse create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public PayResponse notify(String notifyData) {
        return null;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        return null;
    }
}
