package com.example.auth_springsecurity.service;

import com.example.auth_springsecurity.model.Rol;
import com.example.auth_springsecurity.model.Usuario;
import com.example.auth_springsecurity.repository.RolRepository;
import com.example.auth_springsecurity.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario registerUser(String username, String password, String rolNombre) {

        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException("El usuario ya existe");
        }

        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = Usuario.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .rol(rol)
                .enabled(true)
                .build();

        return usuarioRepository.save(usuario);
    }
}
