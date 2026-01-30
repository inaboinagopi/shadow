package com.shadowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowapp.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {}