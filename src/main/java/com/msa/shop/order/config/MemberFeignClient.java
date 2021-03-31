package com.msa.shop.order.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "member", url = "http://member-service-external")
public interface MemberFeignClient {
    @GetMapping("/member/{id}")
    void getMember(@PathVariable String id);


}
