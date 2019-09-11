package com.yhj.order.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.yhj.order.domain.ProductOrder;
import com.yhj.order.service.ProductClient;
import com.yhj.order.service.ProductOrderService;
import com.yhj.order.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private ProductClient productClient;


//    @Autowired
//    private RestTemplate restTemplate;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {


   //     Map forObject = restTemplate.getForObject("http://product-service/api/v1/product/list/" + productId, Map.class);


        ProductOrder productOrder = new ProductOrder();
        String result = productClient.findById(productId);

        JsonNode jsonNode = JsonUtils.convertString2JsonNode(result);

        log.info("forObject \t" + jsonNode);

        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return productOrder;
    }

    @Override
    public Object list() {
        return productClient.list();
    }
}
