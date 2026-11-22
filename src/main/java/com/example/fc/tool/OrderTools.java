package com.example.fc.tool;

import com.example.fc.order.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class OrderTools {

    private static final Logger log = LoggerFactory.getLogger(OrderTools.class);

    private final OrderRepository orderRepository;

    public OrderTools(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Tool(name = "getOrderStatus", description = """
       주문 번호로 현재 로그인한 사용자의 주문 상태와
       도착 예정일을 조회한다.
       상태 값: 결제완료, 배송준비중, 배송중, 배송완료.
       사용자가 특정 주문의 배송 상태, 위치, 도착 시점을
       물을 때 사용한다.
       주문 번호를 알 수 없으면 이 도구를 호출하지 말고
       사용자에게 주문 번호를 먼저 물어본다.
       """)
    public OrderStatusResult getOrderStatus(
        @ToolParam(description = "조회할 주문 번호. 'ORD-' 뒤에 숫자 4자리 형식 (예: ORD-1001)")
        String orderId
    ) {
        return orderRepository.findById(orderId)
                .map(OrderStatusResult::from)
                .orElseGet(() -> OrderStatusResult.notFound(orderId));
    }
}
