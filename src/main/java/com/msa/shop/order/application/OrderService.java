package com.msa.shop.order.application;

import com.msa.shop.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public void getOrder(String id) {

    }
}
