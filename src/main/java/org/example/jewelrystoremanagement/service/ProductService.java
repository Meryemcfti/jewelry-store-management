package org.example.jewelrystoremanagement.service;

import org.example.jewelrystoremanagement.dto.ProductRequest;
import org.example.jewelrystoremanagement.entity.Product;
import org.example.jewelrystoremanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();

        product.setProductName(productRequest.getProductName());
        product.setBrand(productRequest.getBrand());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setKarat(productRequest.getKarat());
        product.setGram(productRequest.getGram());

        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            existingProduct.setProductName(productRequest.getProductName());
            existingProduct.setBrand(productRequest.getBrand());
            existingProduct.setPrice(productRequest.getPrice());
            existingProduct.setStockQuantity(productRequest.getStockQuantity());
            existingProduct.setKarat(productRequest.getKarat());
            existingProduct.setGram(productRequest.getGram());

            return productRepository.save(existingProduct);
        }

        return null;
    }

    @Transactional
    public boolean deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    public List<Product> getProductsByKarat(Integer karat) {
        return productRepository.findByKarat(karat);
    }

    public List<Product> getProductsByPrice(Double price) {
        return productRepository.findByPriceGreaterThan(price);
    }
}
