package org.example.jewelrystoremanagement.controller;

import jakarta.validation.Valid;
import org.example.jewelrystoremanagement.dto.SupplierRequest;
import org.example.jewelrystoremanagement.entity.Supplier;
import org.example.jewelrystoremanagement.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(supplier -> ResponseEntity.ok(supplier))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@Valid @RequestBody SupplierRequest supplierRequest) {
        Supplier createdSupplier = supplierService.createSupplier(supplierRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(
            @PathVariable Long id,
            @Valid @RequestBody SupplierRequest supplierRequest
    ) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplierRequest);

        if (updatedSupplier != null) {
            return ResponseEntity.ok(updatedSupplier);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        boolean deleted = supplierService.deleteSupplier(id);

        if (deleted) {
            return ResponseEntity.ok("Tedarikçi silindi.");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/company/{companyName}")
    public List<Supplier> getSuppliersByCompanyName(@PathVariable String companyName) {
        return supplierService.getSuppliersByCompanyName(companyName);
    }

    @GetMapping("/search-contact")
    public List<Supplier> searchSuppliersByContactName(@RequestParam String contactName) {
        return supplierService.searchSuppliersByContactName(contactName);
    }
}
