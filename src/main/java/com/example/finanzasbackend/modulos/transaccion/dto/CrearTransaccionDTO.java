package com.example.finanzasbackend.modulos.transaccion.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID; 

public record CrearTransaccionDTO(
    UUID usuarioId, 
    Long cuentaOrigenId,
    Long cuentaDestinoId,
    Long categoriaId,
    String tipoTransaccion,
    BigDecimal monto,
    String descripcion,
    LocalDate fechaMovimiento
) {}