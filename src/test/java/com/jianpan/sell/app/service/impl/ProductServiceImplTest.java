package com.jianpan.sell.app.service.impl;

import com.jianpan.sell.app.domain.ProductInfo;
import com.jianpan.sell.app.enums.ProductStatusEnum;
import com.jianpan.sell.app.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo info = productService.findOne("2323");
        Assert.assertEquals("2323", info.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> infoPage = productService.findUpAll();
        Assert.assertNotEquals(0, infoPage.size());
    }

    @Test
    public void findAll() throws Exception {

        PageRequest pageRequest = new PageRequest(0, 2);
        Page productInfoPage = productService.findAll(pageRequest);
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());

    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1111");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

}