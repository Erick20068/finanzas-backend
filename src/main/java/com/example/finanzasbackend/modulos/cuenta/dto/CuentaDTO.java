package com.example.finanzasbackend.modulos.cuenta.dto;

import java.math.BigDecimal;

public record CuentaDTO(
    Long id,
    String nombre,
    String tipoCuenta,
    BigDecimal saldoActual,
    String colorHex
) {}