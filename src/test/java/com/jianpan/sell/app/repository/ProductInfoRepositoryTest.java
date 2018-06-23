package com.jianpan.sell.app.repository;

import com.jianpan.sell.app.domain.ProductInfo;
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
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("113");
        productInfo.setProductName("麻辣烫");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("非常啦啦啦，必须辣辣撸啊撸");
        productInfo.setProductIcon("http://www.jalf.com/ew3.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(22);
        ProductInfo result =  productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByProductStatus() throws Exception {
       List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(productInfos.size(), 0);
    }

}