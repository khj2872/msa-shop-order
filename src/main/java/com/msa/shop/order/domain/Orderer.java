package com.msa.shop.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Orderer implements Serializable {
    @Column(name = "orderer_id")
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

}
