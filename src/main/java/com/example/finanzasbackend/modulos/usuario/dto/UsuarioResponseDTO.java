package com.example.finanzasbackend.modulos.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDTO {
    private UUID id;
    private String nombreCompleto;
    private String correo;
    private String monedaPreferida;
    private LocalDateTime fechaRegistro;
}