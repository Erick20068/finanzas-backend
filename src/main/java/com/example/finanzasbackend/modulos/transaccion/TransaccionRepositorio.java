package com.example.finanzasbackend.modulos.transaccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransaccionRepositorio extends JpaRepository<TransaccionEntidad, Long> {
    List<TransaccionEntidad> findByUsuarioIdOrderByFechaMovimientoDesc(UUID usuarioId);
}