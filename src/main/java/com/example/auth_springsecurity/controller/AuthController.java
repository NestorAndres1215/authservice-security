package com.example.auth_springsecurity.controller;

import com.example.auth_springsecurity.dto.LoginRequest;
import com.example.auth_springsecurity.dto.RegisterRequest;
import com.example.auth_springsecurity.model.Usuario;
import com.example.auth_springsecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        Usuario usuario = authService.registerUser(
                request.getUsername(),
                request.getPassword(),
                request.getRol().toUpperCase()
        );
        return ResponseEntity.ok("Usuario registrado: " + usuario.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok("Usuario autenticado correctamente: " + loginRequest.getUsername());
    }
}