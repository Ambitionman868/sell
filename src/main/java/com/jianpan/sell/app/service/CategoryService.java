package com.jianpan.sell.app.service;

import com.jianpan.sell.app.domain.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> types);

    ProductCategory save(ProductCategory productCategory);

}
