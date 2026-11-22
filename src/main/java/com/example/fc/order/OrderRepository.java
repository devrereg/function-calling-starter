package com.example.fc.order;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

/**
 * 실습용 인메모리 저장소. 실제 서비스라면 JPA Repository 자리입니다.
 */
@Repository
public class OrderRepository {

    private final Map<String, Order> orders = Map.of(
            "ORD-1001", new Order("ORD-1001", "user-1", "무선 키보드", "배송중", LocalDate.of(2026, 11, 24)),
            "ORD-1002", new Order("ORD-1002", "user-1", "USB-C 허브", "배송완료", LocalDate.of(2026, 11, 18)),
            "ORD-2001", new Order("ORD-2001", "user-2", "게이밍 모니터", "배송준비중", LocalDate.of(2026, 11, 27))
    );

    /** 주문 번호와 소유자가 모두 일치할 때만 반환합니다. */
    public Optional<Order> findByIdAndUserId(String orderId, String userId) {
        return Optional.ofNullable(orders.get(orderId))
                .filter(order -> order.userId().equals(userId));
    }

    /** 소유자 확인 없이 조회합니다. (시작 코드의 취약한 구현에서 사용) */
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }
}
