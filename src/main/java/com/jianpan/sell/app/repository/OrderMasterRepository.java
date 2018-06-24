package com.jianpan.sell.app.repository;

import com.jianpan.sell.app.domain.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findAllByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
