package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.dto.OrderRequest;
import com.ecommerce.orderservice.model.Order;
import com.ecommerce.orderservice.model.OrderItem;
import com.ecommerce.orderservice.model.OrderStatus;
import com.ecommerce.orderservice.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Order placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setUserId(orderRequest.userId());
        List<OrderItem> managedOrderItems = new ArrayList<>();
        for (OrderItem item : orderRequest.orderItems()) {
            managedOrderItems.add(entityManager.merge(item));
        }
        order.setOrderItems(managedOrderItems);
        // Order total amount is calculated based on the sum of the prices of the order items
        order.setStatus(orderRequest.orderStatus());
        order.setOrderDate(orderRequest.orderDate());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void updateOrderStatus(Long orderId, OrderStatus orderStatus) {
        Order order = getOrderById(orderId);
        order.setStatus(orderStatus);
        orderRepository.save(order);
    }
}
