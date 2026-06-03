package org.example.jewelrystoremanagement.service;

import org.example.jewelrystoremanagement.dto.CustomerRequest;
import org.example.jewelrystoremanagement.entity.Customer;
import org.example.jewelrystoremanagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();

        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setAddress(customerRequest.getAddress());

        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Long id, CustomerRequest customerRequest) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();

            existingCustomer.setFirstName(customerRequest.getFirstName());
            existingCustomer.setLastName(customerRequest.getLastName());
            existingCustomer.setEmail(customerRequest.getEmail());
            existingCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
            existingCustomer.setAddress(customerRequest.getAddress());

            return customerRepository.save(existingCustomer);
        }

        return null;
    }

    @Transactional
    public boolean deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Customer> getCustomersByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public List<Customer> searchCustomersByEmail(String email) {
        return customerRepository.findByEmailContaining(email);
    }
}
