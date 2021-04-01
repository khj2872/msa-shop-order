package com.msa.shop.order.application;

import lombok.Getter;

@Getter
public class ProductDetail {
    private String productId;
    private String name;
    private int price;
    private long stock;
    private double savingRate;
}
