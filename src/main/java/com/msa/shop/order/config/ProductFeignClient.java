package com.msa.shop.order.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product", url = "http://product-service-external")
public interface ProductFeignClient {
    @GetMapping("/product/{id}")
    void getProduct(@PathVariable String id);
}
