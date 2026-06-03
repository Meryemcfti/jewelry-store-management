package org.example.jewelrystoremanagement.repository;

import org.example.jewelrystoremanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByEmailContaining(String email);

}
