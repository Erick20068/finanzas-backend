package com.example.finanzasbackend.modulos.cuenta;
import com.example.finanzasbackend.modulos.usuario.UsuarioEntidad;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntidad usuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(name = "tipo_cuenta", nullable = false, length = 20)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", precision = 12, scale = 2)
    private BigDecimal saldoInicial;

    @Column(name = "saldo_actual", precision = 12, scale = 2)
    private BigDecimal saldoActual;

    @Column(name = "color_hex", length = 7)
    private String colorHex;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
}