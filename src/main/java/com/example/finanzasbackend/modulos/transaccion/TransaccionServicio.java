package com.example.finanzasbackend.modulos.transaccion;

import com.example.finanzasbackend.modulos.categoria.CategoriaEntidad;
import com.example.finanzasbackend.modulos.categoria.CategoriaRepositorio;
import com.example.finanzasbackend.modulos.cuenta.CuentaEntidad;
import com.example.finanzasbackend.modulos.cuenta.CuentaRepositorio;
import com.example.finanzasbackend.modulos.transaccion.dto.CrearTransaccionDTO;
import com.example.finanzasbackend.modulos.transaccion.dto.TransaccionDTO;
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
public class TransaccionServicio {

    private final TransaccionRepositorio transaccionRepositorio;
    private final CuentaRepositorio cuentaRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final CategoriaRepositorio categoriaRepositorio;

    @Transactional
    public TransaccionDTO registrarTransaccion(CrearTransaccionDTO dto) {
        UsuarioEntidad usuario = usuarioRepositorio.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        CuentaEntidad cuentaOrigen = cuentaRepositorio.findById(dto.cuentaOrigenId())
                .orElseThrow(() -> new RuntimeException("Cuenta origen no encontrada"));

        CategoriaEntidad categoria = null;
        if (dto.categoriaId() != null) {
            categoria = categoriaRepositorio.findById(dto.categoriaId()).orElse(null);
        }

        CuentaEntidad cuentaDestino = null;

        switch (dto.tipoTransaccion()) {
            case "INGRESO":
                cuentaOrigen.setSaldoActual(cuentaOrigen.getSaldoActual().add(dto.monto()));
                break;
            case "EGRESO":
                cuentaOrigen.setSaldoActual(cuentaOrigen.getSaldoActual().subtract(dto.monto()));
                break;
            case "TRANSFERENCIA":
                if (dto.cuentaDestinoId() == null) throw new IllegalArgumentException("La cuenta destino es obligatoria en transferencias");
                cuentaDestino = cuentaRepositorio.findById(dto.cuentaDestinoId())
                        .orElseThrow(() -> new RuntimeException("Cuenta destino no encontrada"));

                cuentaOrigen.setSaldoActual(cuentaOrigen.getSaldoActual().subtract(dto.monto()));
                cuentaDestino.setSaldoActual(cuentaDestino.getSaldoActual().add(dto.monto()));
                cuentaRepositorio.save(cuentaDestino);
                break;
            default:
                throw new IllegalArgumentException("Tipo de transacción no válido");
        }

        cuentaRepositorio.save(cuentaOrigen);

        TransaccionEntidad transaccion = TransaccionEntidad.builder()
                .usuario(usuario)
                .cuentaOrigen(cuentaOrigen)
                .cuentaDestino(cuentaDestino)
                .categoria(categoria)
                .tipoTransaccion(dto.tipoTransaccion())
                .monto(dto.monto())
                .descripcion(dto.descripcion())
                .fechaMovimiento(dto.fechaMovimiento())
                .build();

        TransaccionEntidad guardada = transaccionRepositorio.save(transaccion);

        return mapearADTO(guardada);
    }

    public List<TransaccionDTO> obtenerHistorialUsuario(UUID usuarioId) {
        return transaccionRepositorio.findByUsuarioIdOrderByFechaMovimientoDesc(usuarioId)
                .stream().map(this::mapearADTO).collect(Collectors.toList());
    }

    private TransaccionDTO mapearADTO(TransaccionEntidad entidad) {
        return new TransaccionDTO(
                entidad.getId(),
                entidad.getTipoTransaccion(),
                entidad.getMonto(),
                entidad.getDescripcion(),
                entidad.getFechaMovimiento(),
                entidad.getCuentaOrigen().getNombre(),
                entidad.getCategoria() != null ? entidad.getCategoria().getNombre() : "Sin categoría"
        );
    }
}