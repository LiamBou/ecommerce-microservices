package com.ecommerce.paymentservice.dto;

import com.ecommerce.paymentservice.model.PaymentStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentResponse {

    private String paymentId;

    private PaymentStatus paymentStatus;
}
