package com.jianpan.sell.app.repository;

import com.jianpan.sell.app.domain.OrderMaster;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private final String OPENID = "110110";


    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123666");
        orderMaster.setBuyerName("waner");
        orderMaster.setBuyerPhone("18033339999");
        orderMaster.setBuyerAddress("惠安东岭");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(34.22));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAllByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<OrderMaster> result = orderMasterRepository.findAllByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, result.getTotalElements());

    }

}