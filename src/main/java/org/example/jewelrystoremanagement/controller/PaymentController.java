package org.example.jewelrystoremanagement.controller;

import jakarta.validation.Valid;
import org.example.jewelrystoremanagement.dto.PaymentRequest;
import org.example.jewelrystoremanagement.entity.Payment;
import org.example.jewelrystoremanagement.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        Payment createdPayment = paymentService.createPayment(paymentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }

    @GetMapping("/method/{paymentMethod}")
    public List<Payment> getPaymentsByMethod(@PathVariable String paymentMethod) {
        return paymentService.getPaymentsByMethod(paymentMethod);
    }

    @PostMapping("/rollback-test")
    public ResponseEntity<Payment> createPaymentWithRollbackTest(@Valid @RequestBody PaymentRequest paymentRequest) {
        Payment createdPayment = paymentService.createPaymentWithRollbackTest(paymentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }
}
