package com.shadowapp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



	@Entity
	@Table(name = "users")
	public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;

	    @Column(nullable = false, unique = true, length = 255)
	    private String email;

	    @Column(nullable = false, length = 255)
	    private String passwordHash;

	    @Column(nullable = false, unique = true, length = 20)
	    private String phone;

	    @Column(nullable = false, length = 100)
	    private String firstName;

	    @Column(nullable = false, length = 100)
	    private String lastName;

	    @Column(length = 500)
	    private String profileImage;

	    private LocalDate dateOfBirth;

	    @Enumerated(EnumType.STRING)
	    private Gender gender;

	    @Column(nullable = false)
	    private Boolean isCustomer = true;

	    @Column(nullable = false)
	    private Boolean isServiceProvider = false;

	    @Column(nullable = false)
	    private Boolean isEmailVerified = false;

	    @Column(nullable = false)
	    private Boolean isPhoneVerified = false;

	    @Column(nullable = false)
	    private Boolean isKycVerified = false;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private Status status = Status.active;

	    private LocalDateTime lastLoginAt;

	    @Column(nullable = false, updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();

	    @Column(nullable = false)
	    private LocalDateTime updatedAt = LocalDateTime.now();

	    @Column(nullable = false)
	    private Boolean isActive = true;

	    // Getters and Setters

	    public enum Gender {
	        Male, Female, Other
	    }

	    public enum Status {
	        active, inactive, suspended, deleted
	    }

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
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

		public String getProfileImage() {
			return profileImage;
		}

		public void setProfileImage(String profileImage) {
			this.profileImage = profileImage;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public Boolean getIsCustomer() {
			return isCustomer;
		}

		public void setIsCustomer(Boolean isCustomer) {
			this.isCustomer = isCustomer;
		}

		public Boolean getIsServiceProvider() {
			return isServiceProvider;
		}

		public void setIsServiceProvider(Boolean isServiceProvider) {
			this.isServiceProvider = isServiceProvider;
		}

		public Boolean getIsEmailVerified() {
			return isEmailVerified;
		}

		public void setIsEmailVerified(Boolean isEmailVerified) {
			this.isEmailVerified = isEmailVerified;
		}

		public Boolean getIsPhoneVerified() {
			return isPhoneVerified;
		}

		public void setIsPhoneVerified(Boolean isPhoneVerified) {
			this.isPhoneVerified = isPhoneVerified;
		}

		public Boolean getIsKycVerified() {
			return isKycVerified;
		}

		public void setIsKycVerified(Boolean isKycVerified) {
			this.isKycVerified = isKycVerified;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public LocalDateTime getLastLoginAt() {
			return lastLoginAt;
		}

		public void setLastLoginAt(LocalDateTime lastLoginAt) {
			this.lastLoginAt = lastLoginAt;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
	    
	    
	

    
    
}


