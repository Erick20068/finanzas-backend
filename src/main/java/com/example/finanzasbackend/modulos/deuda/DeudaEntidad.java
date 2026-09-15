package com.example.finanzasbackend.modulos.deuda;

import com.example.finanzasbackend.modulos.usuario.UsuarioEntidad;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "deudas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeudaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntidad usuario;

    @Column(name = "entidad_persona", nullable = false, length = 150)
    private String entidadPersona;

    @Column(name = "tipo_deuda", nullable = false, length = 20)
    private String tipoDeuda;

    @Column(name = "monto_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal montoTotal;

    @Column(name = "monto_pagado", precision = 12, scale = 2)
    private BigDecimal montoPagado;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(length = 20)
    private String estado = "PENDIENTE";

    @Column(columnDefinition = "TEXT")
    private String notas;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}