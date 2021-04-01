package com.msa.shop.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class Orderer implements Serializable {
    @Embedded
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

}
