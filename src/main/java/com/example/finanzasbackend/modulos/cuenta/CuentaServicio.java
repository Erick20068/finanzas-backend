package com.example.finanzasbackend.modulos.cuenta;

import com.example.finanzasbackend.modulos.cuenta.dto.CrearCuentaDTO;
import com.example.finanzasbackend.modulos.cuenta.dto.CuentaDTO;
import com.example.finanzasbackend.modulos.usuario.UsuarioEntidad;
import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuentaServicio {

    private final CuentaRepositorio cuentaRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public CuentaDTO crearCuenta(CrearCuentaDTO dto) {

        UsuarioEntidad usuario = usuarioRepositorio.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + dto.usuarioId()));


        CuentaEntidad nuevaCuenta = CuentaEntidad.builder()
                .usuario(usuario)
                .nombre(dto.nombre())
                .tipoCuenta(dto.tipoCuenta())
                .saldoInicial(dto.saldoInicial())
                .saldoActual(dto.saldoInicial())
                .colorHex(dto.colorHex())
                .build();

        CuentaEntidad cuentaGuardada = cuentaRepositorio.save(nuevaCuenta);


        return mapearADTO(cuentaGuardada);
    }

    public List<CuentaDTO> obtenerCuentasPorUsuario(UUID usuarioId) {
        return cuentaRepositorio.findByUsuarioId(usuarioId).stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }


    private CuentaDTO mapearADTO(CuentaEntidad entidad) {
        return new CuentaDTO(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getTipoCuenta(),
                entidad.getSaldoActual(),
                entidad.getColorHex()
        );
    }
}