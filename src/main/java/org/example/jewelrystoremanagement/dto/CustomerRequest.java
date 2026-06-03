package org.example.jewelrystoremanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerRequest {

    @NotBlank(message = "Müşteri adı boş bırakılamaz.")
    @Size(min = 2, max = 50, message = "Müşteri adı 2 ile 50 karakter arasında olmalıdır.")
    private String firstName;

    @NotBlank(message = "Müşteri soyadı boş bırakılamaz.")
    @Size(min = 2, max = 50, message = "Müşteri soyadı 2 ile 50 karakter arasında olmalıdır.")
    private String lastName;

    @NotBlank(message = "E-posta boş bırakılamaz.")
    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    private String email;

    @NotBlank(message = "Telefon numarası boş bırakılamaz.")
    private String phoneNumber;

    @Size(max = 250, message = "Adres en fazla 250 karakter olabilir.")
    private String address;

    public CustomerRequest() {
    }

    public CustomerRequest(String firstName, String lastName,
                           String email, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
