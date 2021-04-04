package com.msa.shop.order.events.source;

import com.msa.shop.order.events.Action;
import com.msa.shop.order.events.model.OrderChangeModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class OrderSourceBean {
    private final Source source;

    public void publishOrderCreate(Action action, String orderId) {
        log.info("produce kafka message {} for order id: {}", action, orderId);
        OrderChangeModel orderChangeModel = new OrderChangeModel(OrderChangeModel.class.getTypeName(), action, orderId);

        source.output().send(MessageBuilder.withPayload(orderChangeModel).build());
    }
}
