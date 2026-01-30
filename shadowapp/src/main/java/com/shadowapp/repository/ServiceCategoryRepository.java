package com.shadowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowapp.entity.ServiceCategory;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {}