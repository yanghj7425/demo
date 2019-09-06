package com.yhj.order.hystrix;

import com.yhj.order.service.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口失败回调，做降级处理
 */
@Component
@Slf4j
public class ProductClientFallback implements ProductClient {
    @Override
    public String findById(Integer id) {
        log.info("product service has down");
        return null;
    }

    @Override
    public Object list() {
        return null;
    }
}
