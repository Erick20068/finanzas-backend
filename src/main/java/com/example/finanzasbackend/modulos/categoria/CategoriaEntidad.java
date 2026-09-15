package com.example.finanzasbackend.modulos.categoria;

import com.example.finanzasbackend.modulos.usuario.UsuarioEntidad;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntidad usuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(name = "tipo_categoria", nullable = false, length = 20)
    private String tipoCategoria;

    @Column(length = 50)
    private String icono;

    @Column(name = "color_hex", length = 7)
    private String colorHex;
}