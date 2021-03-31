package com.msa.shop.order.api;

import com.msa.shop.order.application.OrderService;
import com.msa.shop.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class OrderController {
    private OrderService orderService;

//    @GetMapping("/order/{id}")
//    public Order getOrder(@PathVariable String id) {
//        orderService.getOrder(id);
//    }
}
