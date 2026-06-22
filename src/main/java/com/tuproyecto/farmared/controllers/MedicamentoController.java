package com.tuproyecto.farmared.controllers;

import com.tuproyecto.farmared.models.Medicamento;
import com.tuproyecto.farmared.repositories.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @GetMapping("/buscar")
    public ResponseEntity<List<Medicamento>> buscarPorPrincipioActivo(@RequestParam String principioActivo) {
        // Ejecuta la consulta ignorando mayúsculas y minúsculas
        List<Medicamento> resultados = medicamentoRepository.findByPrincipioActivoContainingIgnoreCase(principioActivo);
        
        // Devuelve la lista de medicamentos en formato JSON
        return ResponseEntity.ok(resultados);
    }
}