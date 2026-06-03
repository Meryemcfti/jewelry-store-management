package org.example.jewelrystoremanagement.controller;

import jakarta.validation.Valid;
import org.example.jewelrystoremanagement.dto.ProductRequest;
import org.example.jewelrystoremanagement.entity.Product;
import org.example.jewelrystoremanagement.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        Product createdProduct = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest productRequest
    ) {
        Product updatedProduct = productService.updateProduct(id, productRequest);

        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);

        if (deleted) {
            return ResponseEntity.ok("Ürün silindi.");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable String brand) {
        return productService.getProductsByBrand(brand);
    }

    @GetMapping("/karat/{karat}")
    public List<Product> getProductsByKarat(@PathVariable Integer karat) {
        return productService.getProductsByKarat(karat);
    }

    @GetMapping("/price-greater-than")
    public List<Product> getProductsByPrice(@RequestParam Double price) {
        return productService.getProductsByPrice(price);
    }
}