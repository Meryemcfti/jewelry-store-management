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
- H2 Database (geliştirme/test)
- PostgreSQL Driver
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
Sınıfları veritabanındaki tabloları temsil etmektedir.

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

# Kurulum ve Çalıştırma
Projeyi bilgisayarınıza indirmek için:

```bash
git clone https://github.com/Meryemcfti/jewelry-store-management.git
```
komutunu kullanabilirsiniz.

## Gereksinimler
Projeyi çalıştırabilmek için aşağıdaki yazılımların yüklü olması gerekir:
* Java 17
* Maven
* IntelliJ IDEA
* Postman

## Projeyi Çalıştırma
1. Projeyi IntelliJ IDEA ile açın.
2. Maven bağımlılıklarının yüklenmesini bekleyin.
3. JewelryStoreManagementApplication sınıfını çalıştırın.
4. Uygulama varsayılan olarak aşağıdaki adreste çalışacaktır:

```text
http://localhost:8080
```

## API Testleri
API istekleri Postman üzerinden test edilebilir.

Örnek endpointler:
```text
GET    /products
POST   /products
GET    /customers
POST   /customers
GET    /suppliers
POST   /suppliers
GET    /payments
POST   /payments
```

## Kullanıcı Rolleri
USER
* Sadece GET işlemleri yapabilir.

ADMIN
* GET
* POST
* PUT
* DELETE
işlemlerini yapabilir.

Kullanılan test kullanıcıları:

```text
Kullanıcı Adı: user
Şifre: 1234
```

```text
Kullanıcı Adı: admin
Şifre: 1234
```


