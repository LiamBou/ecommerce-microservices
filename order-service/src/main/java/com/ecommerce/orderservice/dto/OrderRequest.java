package com.ecommerce.orderservice.dto;

import com.ecommerce.orderservice.model.OrderItem;
import com.ecommerce.orderservice.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest (Long id, Long userId, List<OrderItem> orderItems, double totalAmount, OrderStatus status, LocalDateTime orderDate) {
}
