# Jewelry Store Management

# Projenin Amacı

Bu proje Orta Düzey Programlama dersi final projesi için geliştirilmiştir.
Amaç, bir kuyumcu mağazasındaki ürünleri, müşterileri, tedarikçileri ve ödeme işlemlerini yönetebilen bir backend sistemi oluşturmaktır.
Proje Java Spring Boot kullanılarak geliştirilmiştir.
---
# Kullanılan Teknolojiler
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven
- Postman
---

# Projede Bulunan Tablolar
# Product (Ürün)
Kuyumcu mağazasında satılan ürünleri tutar.

Alanlar:
- id
- productName
- brand
- price
- stockQuantity
- karat
- gram
---

## Customer (Müşteri)
Müşteri bilgilerini tutar.

Alanlar:
- id
- firstName
- lastName
- email
- phoneNumber
- address
---

## Supplier (Tedarikçi)
Ürün sağlayan firmaların bilgilerini tutar.

Alanlar:
- id
- companyName
- contactName
- phoneNumber
- email
- address
---

## Payment (Ödeme)
Yapılan ödeme işlemlerini tutar.

Alanlar:
- id
- amount
- paymentMethod
- paymentDate

Ayrıca ödeme kaydı içerisinde:
- customer
- product
ilişkileri bulunmaktadır.
Bu sayede hangi müşterinin hangi ürün için ödeme yaptığı takip edilebilmektedir.
---

# Katmanlı Mimari
Projede Spring Boot'un katmanlı mimarisi kullanılmıştır.
# Entity
Veritabanındaki tabloları temsil eder.

Örnek:
- Product
- Customer
- Supplier
- Payment
---

## Repository
Veritabanı işlemlerini yapmak için kullanılmıştır.

Örnek:
- ProductRepository
- CustomerRepository
- SupplierRepository
- PaymentRepository
---

## Service
İş kurallarının yazıldığı katmandır.

Örneğin:
- Ürün kaydetme
- Ödeme oluşturma
- Filtreleme işlemleri
bu katmanda yapılmıştır.
---

## Controller
Dışarıdan gelen HTTP isteklerini karşılar.
Postman üzerinden gönderilen GET, POST, PUT ve DELETE istekleri burada yönetilir.
---

# DTO ve Validation
Kullanıcıdan gelen verileri doğrudan Entity sınıflarına göndermek yerine DTO kullanılmıştır.

Örnek:
- ProductRequest
- CustomerRequest
- SupplierRequest
- PaymentRequest

Ayrıca hatalı veri girişlerini engellemek için:
- @NotBlank
- @NotNull
- @Positive
- @Email
gibi doğrulamalar kullanılmıştır.
---

# Exception Yönetimi
GlobalExceptionHandler sınıfı kullanılmıştır.
Validation hataları kullanıcıya daha anlaşılır şekilde gösterilmektedir.
---

# Security
Projede Spring Security kullanılmıştır.

İki farklı rol bulunmaktadır:

## USER
Sadece GET işlemleri yapabilir.

## ADMIN
- GET
- POST
- PUT
- DELETE
işlemlerini yapabilir.
---

# Derived Query Methods
Repository katmanında Spring Data JPA'nın Derived Query Methods özelliği kullanılmıştır.

Örnekler:
- findByBrand()
- findByKarat()
- findByPriceGreaterThan()
- findByCompanyName()
- findByContactNameContaining()
- findByPaymentMethod()
Bu metotlar filtreleme işlemleri için kullanılmıştır.
---

# Transaction ve Rollback
PaymentService içerisinde @Transactional kullanılmıştır.
Rollback testi için ayrı bir metot oluşturulmuştur.
Bilinçli olarak hata oluşturulduğunda işlem geri alınmakta ve ödeme kaydı veritabanına eklenmemektedir.
Bu sayede veri bütünlüğü korunmaktadır.
---

# API Testleri
Tüm endpointler Postman üzerinden test edilmiştir.
- GET
- POST
- PUT
- DELETE
işlemleri başarıyla çalışmaktadır.
---

