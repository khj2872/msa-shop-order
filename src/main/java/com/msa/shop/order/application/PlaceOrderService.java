package com.msa.shop.order.application;

import com.msa.shop.order.config.ProductFeignClient;
import com.msa.shop.order.domain.*;
import com.msa.shop.order.events.Action;
import com.msa.shop.order.events.source.OrderSourceBean;
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
    private final OrderSourceBean orderSourceBean;

    public OrderId placeOrder(final OrderRequest orderRequest) {
        final List<OrderLine> orderLines = new ArrayList<>();

        orderRequest.getOrderProducts().forEach(orderProduct -> {
//            final ProductDetail productDetail = productFeignClient.getProduct(orderProduct.getProductId().getId());
            ProductDetail productDetail = ProductDetail.builder()
                    .productId(orderProduct.getProductId().getId())
                    .price(100).build();
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
        Order order = new Order(orderId, orderRequest.getOrderer(), orderLines, orderRequest.getShippingInfo(), OrderState.PREPARING);
        orderRepository.save(order); // TODO delivery service 와 transaction 처리 필요 (SAGA Pattern?)

        // order 생성 후 message queue에 이벤트 발행
        orderSourceBean.publishOrderCreate(Action.CREATE, order.getId().getId());
        return orderId;
    }

}
