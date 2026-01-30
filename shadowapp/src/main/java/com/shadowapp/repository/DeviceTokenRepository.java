package com.shadowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowapp.entity.DeviceToken;

public interface DeviceTokenRepository extends JpaRepository<DeviceToken, Long> {}