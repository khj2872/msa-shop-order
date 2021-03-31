package com.msa.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "address")
    private String address;


}
