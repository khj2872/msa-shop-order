package com.msa.shop.order.api;

import com.msa.shop.order.application.PlaceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;

}
