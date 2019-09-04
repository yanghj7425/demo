package com.yhj.product_service.controller;

import com.yhj.product_service.domain.Product;
import com.yhj.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
@Slf4j
public class ProductController {


    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    @GetMapping("list/{id}")
    public Object findById(@PathVariable(value = "id") Integer id) {

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Product product = productService.queryById(id);
        Product result = Product.builder().build();
        BeanUtils.copyProperties(product, result);
        result.setName(product.getName() + "\tfrom port\t" + port);

        log.info(result.toString());

        return result;
    }

}
