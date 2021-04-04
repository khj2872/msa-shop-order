package com.msa.shop.order.query.application;

import com.msa.shop.order.domain.Orderer;
import com.msa.shop.order.domain.ShippingInfo;
import lombok.Getter;

@Getter
public class OrderDetail {
    private String orderId;
    private Orderer orderer;
    private ShippingInfo shippingInfo;

}
