package com.example.finanzasbackend.modulos.deuda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface DeudaRepositorio extends JpaRepository<DeudaEntidad, Long> {
    List<DeudaEntidad> findByUsuarioIdOrderByFechaVencimientoAsc(UUID usuarioId);
}