package com.yhj.order_service.service;

import com.yhj.order_service.domain.ProductOrder;

public interface ProductOrderService {
    ProductOrder save(Integer userId, Integer productId);

    Object list();
}
