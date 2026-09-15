package com.example.finanzasbackend.modulos.categoria.dto;

public record CategoriaDTO(
        Long id,
        String nombre,
        String tipoCategoria,
        String icono,
        String colorHex
) {}