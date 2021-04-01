package com.msa.shop.order.domain;

import com.msa.shop.order.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order extends BaseTimeEntity {
    @EmbeddedId
    private OrderId id;

    @Embedded
    private Orderer orderer;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @Embedded
    private ShippingInfo shippingInfo;

}
