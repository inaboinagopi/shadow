package com.shadowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowapp.entity.Notification;

public interface NotificationRepository  extends JpaRepository<Notification, Long> {}