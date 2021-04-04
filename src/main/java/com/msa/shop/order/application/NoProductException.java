package com.msa.shop.order.application;

public class NoProductException extends RuntimeException {
    public NoProductException(String productId) {
        super("Cannot find product. productId is " + productId);
    }
}
