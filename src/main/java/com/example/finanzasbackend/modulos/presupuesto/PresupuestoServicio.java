package com.example.finanzasbackend.modulos.presupuesto;

import com.example.finanzasbackend.modulos.categoria.CategoriaEntidad;
import com.example.finanzasbackend.modulos.categoria.CategoriaRepositorio;
import com.example.finanzasbackend.modulos.presupuesto.dto.CrearPresupuestoDTO;
import com.example.finanzasbackend.modulos.presupuesto.dto.PresupuestoDTO;
import com.example.finanzasbackend.modulos.usuario.UsuarioEntidad;
import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PresupuestoServicio {

    private final PresupuestoRepositorio presupuestoRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final CategoriaRepositorio categoriaRepositorio;

    @Transactional
    public PresupuestoDTO registrarPresupuesto(CrearPresupuestoDTO dto) {
        // Validar que no exista ya un presupuesto para esa categoría en ese mes
        presupuestoRepositorio.findByUsuarioIdAndCategoriaIdAndMesAndAnio(
                dto.usuarioId(), dto.categoriaId(), dto.mes(), dto.anio()
        ).ifPresent(p -> {
            throw new RuntimeException("Ya existe un presupuesto para esta categoría en este mes.");
        });

        UsuarioEntidad usuario = usuarioRepositorio.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        CategoriaEntidad categoria = categoriaRepositorio.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        PresupuestoEntidad presupuesto = PresupuestoEntidad.builder()
                .usuario(usuario)
                .categoria(categoria)
                .mes(dto.mes())
                .anio(dto.anio())
                .montoLimite(dto.montoLimite())
                .build();

        PresupuestoEntidad guardado = presupuestoRepositorio.save(presupuesto);
        return mapearADTO(guardado);
    }

    public List<PresupuestoDTO> obtenerPresupuestosDelMes(UUID usuarioId, Integer mes, Integer anio) {
        return presupuestoRepositorio.findByUsuarioIdAndMesAndAnio(usuarioId, mes, anio)
                .stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private PresupuestoDTO mapearADTO(PresupuestoEntidad entidad) {
        return new PresupuestoDTO(
                entidad.getId(),
                entidad.getCategoria().getNombre(),
                entidad.getCategoria().getColorHex(),
                entidad.getMes(),
                entidad.getAnio(),
                entidad.getMontoLimite()
        );
    }
}