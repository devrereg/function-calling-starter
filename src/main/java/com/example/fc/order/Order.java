package com.example.fc.order;

import java.time.LocalDate;


public record Order(
        String orderId,
        String userId,
        String productName,
        String status,          // 결제완료 / 배송준비중 / 배송중 / 배송완료
        LocalDate estimatedArrival
) {
}
