package com.ecommerce.paymentservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "payment")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_status")
    private PaymentStatus status;

    @Column(name = "payment_date")
    private LocalDateTime createdDate;
}
