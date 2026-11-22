package com.example.fc.tool;

import com.example.fc.order.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderTools {

    private static final Logger log = LoggerFactory.getLogger(OrderTools.class);

    private final OrderRepository orderRepository;

    public OrderTools(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public OrderStatusResult getOrderStatus(String orderId) {

        return orderRepository.findById(orderId)
                .map(OrderStatusResult::from)
                .orElseGet(() -> OrderStatusResult.notFound(orderId));
    }
}
