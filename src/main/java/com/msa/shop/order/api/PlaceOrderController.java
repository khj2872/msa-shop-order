package com.msa.shop.order.api;

import com.msa.shop.order.application.OrderRequest;
import com.msa.shop.order.application.PlaceOrderService;
import com.msa.shop.order.domain.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;

    @PostMapping("/orders/order")
    public String order(@RequestBody OrderRequest orderRequest) {
        // TODO validate orderRequest and get member info

        OrderId orderId = placeOrderService.placeOrder(orderRequest);
        return orderId.getId();
    }

}
