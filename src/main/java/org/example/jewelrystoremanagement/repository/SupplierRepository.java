package org.example.jewelrystoremanagement.repository;

import org.example.jewelrystoremanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findByCompanyName(String companyName);

    List<Supplier> findByContactNameContaining(String contactName);
}
