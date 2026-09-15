package com.example.finanzasbackend.modulos.categoria.dto;

import java.util.UUID;

public record CrearCategoriaDTO(
        UUID usuarioId,
        String nombre,
        String tipoCategoria,
        String icono,
        String colorHex
) {}