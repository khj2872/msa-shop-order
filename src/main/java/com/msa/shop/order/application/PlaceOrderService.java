package com.msa.shop.order.application;

import com.msa.shop.order.config.ProductFeignClient;
import com.msa.shop.order.domain.*;
import com.msa.shop.order.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceOrderService {
    private final OrderRepository orderRepository;
    private final ProductFeignClient productFeignClient;

    public OrderId placeOrder(OrderRequest orderRequest) {
        List<OrderLine> orderLines = new ArrayList<>();

        orderRequest.getOrderProducts().forEach(orderProduct -> {
            ProductDetail productDetail = productFeignClient.getProduct(orderProduct.getProductId().getId());
            if (productDetail == null) {
                throw new NoProductException(orderProduct.getProductId().getId());
            }
            orderLines.add(
                    new OrderLine(
                            new ProductId(productDetail.getProductId()),
                            new Money(productDetail.getPrice()),
                            orderProduct.getQuantity()
                    ));
        });
        OrderId orderId = new OrderId(Util.makeRandomUUID());
        Order order = new Order(orderId, orderRequest.getOrderer(), orderLines, orderRequest.getShippingInfo());
        orderRepository.save(order);

        // TODO order 생성 후 message queue 에 delivery 이벤트 발행
        return orderId;
    }

}
