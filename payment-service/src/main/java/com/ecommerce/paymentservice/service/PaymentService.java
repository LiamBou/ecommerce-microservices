package com.ecommerce.paymentservice.service;

import com.ecommerce.paymentservice.dto.PaymentRequest;
import com.ecommerce.paymentservice.dto.PaymentResponse;
import com.ecommerce.paymentservice.model.Payment;
import com.ecommerce.paymentservice.model.PaymentStatus;
import com.ecommerce.paymentservice.repository.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Transactional
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, @Value("${stripe.apikey}") String stripeSecretKey) {
        this.paymentRepository = paymentRepository;
        Stripe.apiKey = stripeSecretKey;
    }

    public PaymentIntent createPaymentIntent(PaymentRequest paymentRequest) throws StripeException {
        HashMap<String, Object> params = new HashMap<>();
        params.put("amount", paymentRequest.getAmount());
        params.put("currency", "usd");
        params.put("payment_method_types", paymentRequest.getPaymentMethod());

        return PaymentIntent.create(params);
    }

    public ResponseEntity<String> stripePayment(String userEmail) throws Exception {
        Payment payment = paymentRepository.findByUserEmail(userEmail);

        if (payment == null) {
            throw new Exception("Payment not found");
        }

        payment.setStatus(PaymentStatus.COMPLETED);
        paymentRepository.save(payment);

        return ResponseEntity.ok("Payment successful");
    }
}
