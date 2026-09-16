package com.example.finanzasbackend.modulos.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, UUID> {
    boolean existsByCorreo(String correo);
}