package com.shadowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowapp.entity.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {}