package com.example.finanzasbackend.modulos.cuenta;

import com.example.finanzasbackend.modulos.cuenta.dto.CrearCuentaDTO;
import com.example.finanzasbackend.modulos.cuenta.dto.CuentaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class CuentaControlador {

    private final CuentaServicio cuentaServicio;

    @PostMapping
    public ResponseEntity<CuentaDTO> crearCuenta(@RequestBody CrearCuentaDTO dto) {
        CuentaDTO cuentaCreada = cuentaServicio.crearCuenta(dto);
        return new ResponseEntity<>(cuentaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<CuentaDTO>> obtenerCuentasDeUsuario(@PathVariable UUID usuarioId) {
        List<CuentaDTO> cuentas = cuentaServicio.obtenerCuentasPorUsuario(usuarioId);
        return ResponseEntity.ok(cuentas);
    }
}