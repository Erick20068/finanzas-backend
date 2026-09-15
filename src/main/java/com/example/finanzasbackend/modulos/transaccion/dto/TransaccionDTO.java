package com.example.finanzasbackend.modulos.transaccion.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransaccionDTO(
        Long id,
        String tipoTransaccion,
        BigDecimal monto,
        String descripcion,
        LocalDate fechaMovimiento,
        String nombreCuentaOrigen,
        String nombreCategoria
) {}