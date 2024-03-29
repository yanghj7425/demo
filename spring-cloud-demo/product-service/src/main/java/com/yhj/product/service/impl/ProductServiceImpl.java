package com.yhj.product.service.impl;

import com.yhj.product.domain.Product;
import com.yhj.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {


    private static final Map<Integer, Product> mapDao = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            Product p1 = Product.builder().Id(i * 2).image("image" + i).name("电脑" + i).price(10000).store(11).build();
            mapDao.put(p1.getId(), p1);
        }

    }

    @Override
    public List<Product> listProduct() {


        return new ArrayList<>(mapDao.values());
    }

    @Override
    public Product queryById(Integer id) {
        return mapDao.get(id);
    }
}
