package com.jianpan.sell.app.controller;


import com.jianpan.sell.app.domain.ProductCategory;
import com.jianpan.sell.app.domain.ProductInfo;
import com.jianpan.sell.app.service.ProductService;
import com.jianpan.sell.app.service.impl.CategotyServiceImpl;
import com.jianpan.sell.app.service.impl.ProductServiceImpl;
import com.jianpan.sell.app.utils.ResultVOUtil;
import com.jianpan.sell.app.vo.ProductInfoVO;
import com.jianpan.sell.app.vo.ProductVO;
import com.jianpan.sell.app.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategotyServiceImpl categotyService;

    @GetMapping("/list")
    private ResultVO<List<ProductVO>> list() {
        //1. 查询所有的上架商品
        List<ProductInfo> productInfos = productService.findUpAll();
        //2. 查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        //精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfos.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategories = categotyService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOS = new ArrayList<>();

        for (ProductCategory productCategory : productCategories) {

            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOS = new ArrayList<>();

            for (ProductInfo productInfo : productInfos) {

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOS);
            productVOS.add(productVO);
        }


        return ResultVOUtil.success(productVOS);
    }
}
