package com.yhj.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yhj.order.domain.ProductOrder;
import com.yhj.order.service.ProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1/order")
@Slf4j
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("list")
    public Object list() {
        return productOrderService.list();
    }

    @GetMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFailure")
    public Object save(Integer userId, Integer productId) {
        ProductOrder productOrder = productOrderService.save(userId, productId);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", productOrder);
        return result;

    }

    private Object saveOrderFailure(Integer userId, Integer productId) {

        String orderService = "ORDER_SERVICE";
        String sendValue = stringRedisTemplate.opsForValue().get(orderService);
        new Thread(() -> {
            if (StringUtils.isEmpty(sendValue)) {
                log.info("order service has down ,please fix right now");
                stringRedisTemplate.opsForValue().set(orderService, "save-order-fail", 20, TimeUnit.SECONDS);
            } else {
                log.info("message has send");
            }
        }).start();


        Map<String, Object> result = new HashMap<>();
        result.put("code", -1);
        result.put("msg", "请稍后再试");
        return result;
    }
}
