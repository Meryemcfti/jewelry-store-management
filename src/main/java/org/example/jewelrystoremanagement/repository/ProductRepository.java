package org.example.jewelrystoremanagement.repository;

import org.example.jewelrystoremanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBrand(String brand);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByKarat(Integer karat);
}
