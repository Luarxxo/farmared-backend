package com.tuproyecto.farmared.repositories;

import com.tuproyecto.farmared.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método derivado para buscar credenciales en el login
    Optional<Usuario> findByUsername(String username);
}