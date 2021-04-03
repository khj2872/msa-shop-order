package com.msa.shop.order.events.source;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class DeliverySourceBean {
    private final Source source;

    public void publishOrderCreate() {

    }
}
