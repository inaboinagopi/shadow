package com.shadowapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDto {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
