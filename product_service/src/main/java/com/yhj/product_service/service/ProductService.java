package com.yhj.product_service.service;

import com.yhj.product_service.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product queryById(Integer id);

}
