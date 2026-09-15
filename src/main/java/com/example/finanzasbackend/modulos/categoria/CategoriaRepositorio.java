package com.example.finanzasbackend.modulos.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface CategoriaRepositorio extends JpaRepository<CategoriaEntidad, Long> {
    List<CategoriaEntidad> findByUsuarioId(UUID usuarioId);
}