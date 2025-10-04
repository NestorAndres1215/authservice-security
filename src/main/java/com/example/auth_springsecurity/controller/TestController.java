package com.example.auth_springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hola USER o ADMIN, estás autenticado!";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hola ADMIN, solo tú puedes ver esto!";
    }
}