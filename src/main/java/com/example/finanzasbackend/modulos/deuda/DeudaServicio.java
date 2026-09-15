package com.example.finanzasbackend.modulos.deuda;

import com.example.finanzasbackend.modulos.deuda.dto.CrearDeudaDTO;
import com.example.finanzasbackend.modulos.deuda.dto.DeudaDTO;
import com.example.finanzasbackend.modulos.usuario.UsuarioEntidad;
import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeudaServicio {

    private final DeudaRepositorio deudaRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public DeudaDTO crearDeuda(CrearDeudaDTO dto) {
        UsuarioEntidad usuario = usuarioRepositorio.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        DeudaEntidad nuevaDeuda = DeudaEntidad.builder()
                .usuario(usuario)
                .entidadPersona(dto.entidadPersona())
                .tipoDeuda(dto.tipoDeuda())
                .montoTotal(dto.montoTotal())
                .montoPagado(BigDecimal.ZERO)
                .fechaVencimiento(dto.fechaVencimiento())
                .estado("PENDIENTE")
                .notas(dto.notas())
                .build();

        return mapearADTO(deudaRepositorio.save(nuevaDeuda));
    }

    public List<DeudaDTO> obtenerDeudasPorUsuario(UUID usuarioId) {
        return deudaRepositorio.findByUsuarioIdOrderByFechaVencimientoAsc(usuarioId).stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private DeudaDTO mapearADTO(DeudaEntidad entidad) {
        return new DeudaDTO(entidad.getId(), entidad.getEntidadPersona(), entidad.getTipoDeuda(),
                entidad.getMontoTotal(), entidad.getMontoPagado(), entidad.getFechaVencimiento(),
                entidad.getEstado(), entidad.getNotas());
    }
}