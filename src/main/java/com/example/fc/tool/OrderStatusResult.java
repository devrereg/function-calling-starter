package com.example.fc.tool;

import com.example.fc.order.Order;

public record OrderStatusResult(
        boolean found,
        String orderId,
        String productName,
        String status,
        String estimatedArrival,
        String message
) {

    public static OrderStatusResult from(Order order) {
        return new OrderStatusResult(true, order.orderId(), order.productName(),
                order.status(), order.estimatedArrival().toString(), null);
    }

    public static OrderStatusResult notFound(String orderId) {
        return new OrderStatusResult(false, orderId, null, null, null,
                "해당 주문을 찾을 수 없습니다. 주문 번호를 다시 확인해 주세요.");
    }

    public static OrderStatusResult invalidFormat(String orderId) {
        return new OrderStatusResult(false, orderId, null, null, null,
                "주문 번호 형식이 올바르지 않습니다. 형식: ORD-숫자4자리 (예: ORD-1001)");
    }
}
