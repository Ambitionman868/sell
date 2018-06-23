package com.jianpan.sell.app.service.impl;

import com.jianpan.sell.app.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategotyServiceImplTest {

    @Autowired
    private CategotyServiceImpl categotyService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categotyService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {

        List<ProductCategory> categories = categotyService.findAll();
        Assert.assertNotEquals(categories.size(), 0);

    }

    @Test
    public void findByCategoryTypeIn() throws Exception {

        List<ProductCategory> categories = categotyService.findByCategoryTypeIn(Arrays.asList(5));
        Assert.assertNotEquals(categories.size(), 0);
    }

    @Test
    public void save() throws Exception {

        ProductCategory productCategory = new ProductCategory("我喜欢", 33);
        ProductCategory result = categotyService.save(productCategory);
        Assert.assertNotNull(result);
    }

}