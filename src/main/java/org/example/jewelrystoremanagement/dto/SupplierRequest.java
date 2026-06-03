package org.example.jewelrystoremanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SupplierRequest {

    @NotBlank(message = "Firma adı boş bırakılamaz.")
    @Size(min = 2, max = 100, message = "Firma adı 2 ile 100 karakter arasında olmalıdır.")
    private String companyName;

    @NotBlank(message = "Yetkili kişi adı boş bırakılamaz.")
    @Size(min = 2, max = 100, message = "Yetkili kişi adı 2 ile 100 karakter arasında olmalıdır.")
    private String contactName;

    @NotBlank(message = "Telefon numarası boş bırakılamaz.")
    private String phoneNumber;

    @NotBlank(message = "E-posta boş bırakılamaz.")
    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    private String email;

    @Size(max = 250, message = "Adres en fazla 250 karakter olabilir.")
    private String address;

    public SupplierRequest() {
    }

    public SupplierRequest(String companyName, String contactName,
                           String phoneNumber, String email, String address) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
