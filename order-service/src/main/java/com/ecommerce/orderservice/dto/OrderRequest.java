package com.ecommerce.orderservice.dto;

import com.ecommerce.orderservice.model.OrderItem;
import com.ecommerce.orderservice.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(String userId, List<OrderItem> orderItems, OrderStatus orderStatus,
                           LocalDateTime orderDate) {
}
