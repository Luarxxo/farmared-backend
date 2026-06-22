package com.tuproyecto.farmared.controllers;

import com.tuproyecto.farmared.models.Usuario;
import com.tuproyecto.farmared.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Busca al usuario en PostgreSQL por su username
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(request.getUsername());

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            
            // Validación de contraseña (En producción se utiliza BCryptPasswordEncoder)
            if (usuario.getPasswordHash().equals(request.getPassword())) {
                // Generación simulada de Token JWT
                String mockToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.simulado." + usuario.getId();
                return ResponseEntity.ok(new AuthResponse(mockToken));
            }
        }
        
        // Retorna error 401 si las credenciales fallan
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}

// Clases de Transferencia de Datos (DTOs)
class LoginRequest {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class AuthResponse {
    private String token;

    public AuthResponse(String token) { this.token = token; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}