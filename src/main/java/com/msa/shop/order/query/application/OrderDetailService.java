package com.msa.shop.order.query.application;

import com.msa.shop.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderRepository orderRepository;

}
