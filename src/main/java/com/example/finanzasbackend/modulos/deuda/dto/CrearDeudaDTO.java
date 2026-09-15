package com.example.finanzasbackend.modulos.deuda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CrearDeudaDTO(
        UUID usuarioId,
        String entidadPersona,
        String tipoDeuda,
        BigDecimal montoTotal,
        LocalDate fechaVencimiento,
        String notas
) {}