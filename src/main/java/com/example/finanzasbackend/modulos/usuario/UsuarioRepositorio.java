package com.example.finanzasbackend.modulos.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, UUID> {}