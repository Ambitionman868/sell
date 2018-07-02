package com.jianpan.sell.app.service.impl;

import com.jianpan.sell.app.domain.SellerInfo;
import com.jianpan.sell.app.repository.SellerInfoRepository;
import com.jianpan.sell.app.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
