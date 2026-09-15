package com.example.finanzasbackend.modulos.presupuesto.dto;

import java.math.BigDecimal;

public record PresupuestoDTO(
        Long id,
        String categoriaNombre,
        String colorHexCategoria, 
        Integer mes,
        Integer anio,
        BigDecimal montoLimite
) {}