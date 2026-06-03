package org.example.jewelrystoremanagement.service;

import org.example.jewelrystoremanagement.dto.SupplierRequest;
import org.example.jewelrystoremanagement.entity.Supplier;
import org.example.jewelrystoremanagement.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    @Transactional
    public Supplier createSupplier(SupplierRequest supplierRequest) {
        Supplier supplier = new Supplier();

        supplier.setCompanyName(supplierRequest.getCompanyName());
        supplier.setContactName(supplierRequest.getContactName());
        supplier.setPhoneNumber(supplierRequest.getPhoneNumber());
        supplier.setEmail(supplierRequest.getEmail());
        supplier.setAddress(supplierRequest.getAddress());

        return supplierRepository.save(supplier);
    }

    @Transactional
    public Supplier updateSupplier(Long id, SupplierRequest supplierRequest) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            Supplier existingSupplier = optionalSupplier.get();

            existingSupplier.setCompanyName(supplierRequest.getCompanyName());
            existingSupplier.setContactName(supplierRequest.getContactName());
            existingSupplier.setPhoneNumber(supplierRequest.getPhoneNumber());
            existingSupplier.setEmail(supplierRequest.getEmail());
            existingSupplier.setAddress(supplierRequest.getAddress());

            return supplierRepository.save(existingSupplier);
        }

        return null;
    }

    @Transactional
    public boolean deleteSupplier(Long id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            supplierRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Supplier> getSuppliersByCompanyName(String companyName) {
        return supplierRepository.findByCompanyName(companyName);
    }

    public List<Supplier> searchSuppliersByContactName(String contactName) {
        return supplierRepository.findByContactNameContaining(contactName);
    }
}
