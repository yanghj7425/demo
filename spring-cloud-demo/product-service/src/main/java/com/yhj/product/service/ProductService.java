package com.yhj.product.service;


import com.yhj.product.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product queryById(Integer id);

}
