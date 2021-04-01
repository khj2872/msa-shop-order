package com.msa.shop.order.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "address")
    private String address;

    @Embedded
    private Receiver receiver;
}
