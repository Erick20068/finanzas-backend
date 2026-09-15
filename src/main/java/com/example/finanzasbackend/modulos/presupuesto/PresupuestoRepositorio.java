package com.example.finanzasbackend.modulos.presupuesto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PresupuestoRepositorio extends JpaRepository<PresupuestoEntidad, Long> {
    
    List<PresupuestoEntidad> findByUsuarioIdAndMesAndAnio(UUID usuarioId, Integer mes, Integer anio);
    
    Optional<PresupuestoEntidad> findByUsuarioIdAndCategoriaIdAndMesAndAnio(UUID usuarioId, Long categoriaId, Integer mes, Integer anio);
}