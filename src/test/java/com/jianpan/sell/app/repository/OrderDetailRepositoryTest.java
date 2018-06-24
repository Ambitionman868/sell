package com.jianpan.sell.app.repository;

import com.jianpan.sell.app.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void saveTest() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("33333");
        orderDetail.setOrderId("123455");
        orderDetail.setProductIcon("http://wewwtt.jpg");
        orderDetail.setProductId("677777");
        orderDetail.setProductName("烧腊系列套餐");
        orderDetail.setProductPrice(new BigDecimal(22.8));
        orderDetail.setProductQuantity(7);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("123455");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}