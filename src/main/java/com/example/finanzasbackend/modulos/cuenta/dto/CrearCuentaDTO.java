package com.example.finanzasbackend.modulos.cuenta.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CrearCuentaDTO(
        UUID usuarioId,
        String nombre,
        String tipoCuenta,
        BigDecimal saldoInicial,
        String colorHex
) {}