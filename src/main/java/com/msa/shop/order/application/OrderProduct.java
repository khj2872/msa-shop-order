package com.msa.shop.order.application;

import com.msa.shop.order.domain.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    private ProductId productId;
    private int quantity;
}
