package com.shadowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowapp.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {}
