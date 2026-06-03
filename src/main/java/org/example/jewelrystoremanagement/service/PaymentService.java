package org.example.jewelrystoremanagement.service;

import org.example.jewelrystoremanagement.dto.PaymentRequest;
import org.example.jewelrystoremanagement.entity.Customer;
import org.example.jewelrystoremanagement.entity.Payment;
import org.example.jewelrystoremanagement.entity.Product;
import org.example.jewelrystoremanagement.repository.CustomerRepository;
import org.example.jewelrystoremanagement.repository.PaymentRepository;
import org.example.jewelrystoremanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          CustomerRepository customerRepository,
                          ProductRepository productRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public List<Payment> getPaymentsByMethod(String paymentMethod) {
        return paymentRepository.findByPaymentMethod(paymentMethod);
    }

    @Transactional
    public Payment createPayment(PaymentRequest paymentRequest) {
        Customer customer = customerRepository.findById(paymentRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));

        Product product = productRepository.findById(paymentRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı."));

        Payment payment = new Payment();

        payment.setCustomer(customer);
        payment.setProduct(product);
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment createPaymentWithRollbackTest(PaymentRequest paymentRequest) {
        Customer customer = customerRepository.findById(paymentRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı."));

        Product product = productRepository.findById(paymentRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı."));

        Payment payment = new Payment();

        payment.setCustomer(customer);
        payment.setProduct(product);
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setPaymentDate(LocalDateTime.now());

        Payment savedPayment = paymentRepository.save(payment);

        if (true) {
            throw new RuntimeException("Rollback testi için bilinçli hata oluşturuldu.");
        }

        return savedPayment;
    }
}
