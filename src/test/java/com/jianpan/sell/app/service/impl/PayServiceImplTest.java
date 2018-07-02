package com.jianpan.sell.app.service.impl;

import com.jianpan.sell.app.dto.OrderDTO;
import com.jianpan.sell.app.service.OrderService;
import com.jianpan.sell.app.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1529826434747999505");
        payService.create(orderDTO);
    }

   /* @Test
    public void notify() throws Exception {
    }*/

    @Test
    public void refund() throws Exception {
    }

}