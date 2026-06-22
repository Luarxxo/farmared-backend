package com.tuproyecto.farmared.repositories;

import com.tuproyecto.farmared.models.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    // Método derivado para la barra de búsqueda semántica (ignorando mayúsculas/minúsculas)
    List<Medicamento> findByPrincipioActivoContainingIgnoreCase(String principioActivo);
}