package com.msa.shop.order.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ShippingInfo {
    private Address address;
}
