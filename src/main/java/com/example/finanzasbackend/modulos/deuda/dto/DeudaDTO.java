package com.example.finanzasbackend.modulos.deuda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DeudaDTO(
        Long id,
        String entidadPersona,
        String tipoDeuda,
        BigDecimal montoTotal,
        BigDecimal montoPagado,
        LocalDate fechaVencimiento,
        String estado,
        String notas
) {}