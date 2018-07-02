package com.jianpan.sell.app.service;

import com.jianpan.sell.app.domain.SellerInfo;

public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
