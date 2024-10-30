package com.ecommerce.paymentservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentRequest {
    private Long orderId;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotBlank
    private String paymentMethod;

    @NotBlank
    private String receiptEmail;
}
