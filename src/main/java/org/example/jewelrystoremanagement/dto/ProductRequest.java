package org.example.jewelrystoremanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotBlank(message = "Ürün adı boş bırakılamaz.")
    @Size(min = 3, max = 100, message = "Ürün adı 3 ile 100 karakter arasında olmalıdır.")
    private String productName;

    @NotBlank(message = "Marka boş bırakılamaz.")
    @Size(min = 2, max = 50, message = "Marka 2 ile 50 karakter arasında olmalıdır.")
    private String brand;

    @NotNull(message = "Fiyat boş bırakılamaz.")
    @Positive(message = "Fiyat 0'dan büyük olmalıdır.")
    private Double price;

    @NotNull(message = "Stok miktarı boş bırakılamaz.")
    @PositiveOrZero(message = "Stok miktarı negatif olamaz.")
    private Integer stockQuantity;

    @NotNull(message = "Ayar bilgisi boş bırakılamaz.")
    @Positive(message = "Ayar bilgisi 0'dan büyük olmalıdır.")
    private Integer karat;

    @NotNull(message = "Gram bilgisi boş bırakılamaz.")
    @Positive(message = "Gram bilgisi 0'dan büyük olmalıdır.")
    private Double gram;

    public ProductRequest() {
    }

    public ProductRequest(String productName, String brand, Double price,
                          Integer stockQuantity, Integer karat, Double gram) {
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.karat = karat;
        this.gram = gram;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getKarat() {
        return karat;
    }

    public void setKarat(Integer karat) {
        this.karat = karat;
    }

    public Double getGram() {
        return gram;
    }

    public void setGram(Double gram) {
        this.gram = gram;
    }
}
