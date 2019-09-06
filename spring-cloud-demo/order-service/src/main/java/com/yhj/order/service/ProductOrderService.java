package com.yhj.order.service;


import com.yhj.order.domain.ProductOrder;

public interface ProductOrderService {
    ProductOrder save(Integer userId, Integer productId);

    Object list();
}
