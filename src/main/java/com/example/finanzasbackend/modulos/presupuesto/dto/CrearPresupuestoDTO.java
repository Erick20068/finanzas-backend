package com.example.finanzasbackend.modulos.presupuesto.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CrearPresupuestoDTO(
        UUID usuarioId,
        Long categoriaId,
        Integer mes,
        Integer anio,
        BigDecimal montoLimite
) {}