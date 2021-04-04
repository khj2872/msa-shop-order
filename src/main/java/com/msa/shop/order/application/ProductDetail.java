package com.msa.shop.order.application;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDetail {
    private String productId;
    private String name;
    private int price;
    private long stock;
    private double savingRate;
}
