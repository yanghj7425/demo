package com.yhj.order.service;

import com.yhj.order.hystrix.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", fallback = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("api/v1/product/list/{id}")
    String findById(@PathVariable(value = "id") Integer id);


    @GetMapping("api/v1/product/list")
    Object list();

}
