package org.example.jewelrystoremanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String brand;
    private Double price;
    private Integer stockQuantity;
    private Integer karat;
    private Double gram;

    public Product() {
    }

    public Product(Long id, String productName, String brand, Double price,
                   Integer stockQuantity, Integer karat, Double gram) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.karat = karat;
        this.gram = gram;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public Integer getStockQuantity() { return stockQuantity; }

    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public Integer getKarat() { return karat; }

    public void setKarat(Integer karat) { this.karat = karat; }

    public Double getGram() { return gram; }

    public void setGram(Double gram) { this.gram = gram; }
}

//Product Entity neden var? :Product entity’si, kuyumcu sistemindeki ürünleri
// veritabanında tutabilmek için oluşturuldu.”
//Neden @Entity kullandın?:Bu class’ın veritabanında tablo olarak kullanılabilmesi için @Entity kullandım.”
//Neden @Id kullandın?: Her ürünün benzersiz bir kimlik numarası olması için kullandım
//Neden @GeneratedValue kullandın? //id değerlerinin otomatik artması için kullandım

