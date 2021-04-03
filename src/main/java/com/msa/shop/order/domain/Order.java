package com.msa.shop.order.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseTimeEntity {
    @EmbeddedId
    private OrderId id;

    @Embedded
    private Orderer orderer;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @Embedded
    private ShippingInfo shippingInfo;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    public Order(OrderId orderId, Orderer orderer, List<OrderLine> orderLines,
                 ShippingInfo shippingInfo, OrderState state) {
        setId(orderId);
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
    }

    private void setId(OrderId id) {
        if (id == null) {
            throw new IllegalArgumentException("orderId is null");
        }
        this.id = id;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) {
            throw new IllegalArgumentException("orderer is null");
        }
        this.orderer = orderer;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("orderLine is null");
        }
        this.orderLines = orderLines;
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("shippingInfo");
        }
    }

}
