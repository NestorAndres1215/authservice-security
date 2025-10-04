package com.example.auth_springsecurity.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String rol ; // Valor por defecto
}