package com.msa.shop.order.application;

import com.msa.shop.order.domain.Orderer;
import com.msa.shop.order.domain.ShippingInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderRequest {
    private List<OrderProduct> orderProducts;
    private Orderer orderer;
    private ShippingInfo shippingInfo;
}
