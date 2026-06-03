package org.example.jewelrystoremanagement.controller;

import jakarta.validation.Valid;
import org.example.jewelrystoremanagement.dto.CustomerRequest;
import org.example.jewelrystoremanagement.entity.Customer;
import org.example.jewelrystoremanagement.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(customer -> ResponseEntity.ok(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer createdCustomer = customerService.createCustomer(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerRequest customerRequest
    ) {
        Customer updatedCustomer = customerService.updateCustomer(id, customerRequest);

        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        boolean deleted = customerService.deleteCustomer(id);

        if (deleted) {
            return ResponseEntity.ok("Müşteri silindi.");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lastname/{lastName}")
    public List<Customer> getCustomersByLastName(@PathVariable String lastName) {
        return customerService.getCustomersByLastName(lastName);
    }

    @GetMapping("/search-email")
    public List<Customer> searchCustomersByEmail(@RequestParam String email) {
        return customerService.searchCustomersByEmail(email);
    }
}
