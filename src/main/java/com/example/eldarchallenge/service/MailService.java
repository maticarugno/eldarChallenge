package com.example.eldarchallenge.service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void sendMail(String email, String asunto, String cuerpo);
}
