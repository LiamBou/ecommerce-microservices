package com.ecommerce.orderservice.dto;

import com.ecommerce.orderservice.model.OrderItem;

import java.util.List;

public record OrderRequest (Long userId, List<OrderItem> orderItems) {
}
