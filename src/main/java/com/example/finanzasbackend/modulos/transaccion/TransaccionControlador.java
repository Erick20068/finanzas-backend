package com.example.finanzasbackend.modulos.transaccion;

import com.example.finanzasbackend.modulos.transaccion.dto.CrearTransaccionDTO;
import com.example.finanzasbackend.modulos.transaccion.dto.TransaccionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transacciones")
@RequiredArgsConstructor
public class TransaccionControlador {

    private final TransaccionServicio transaccionServicio;

    @PostMapping
    public ResponseEntity<TransaccionDTO> registrarTransaccion(@RequestBody CrearTransaccionDTO dto) {
        TransaccionDTO nuevaTransaccion = transaccionServicio.registrarTransaccion(dto);
        return new ResponseEntity<>(nuevaTransaccion, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<TransaccionDTO>> obtenerHistorial(@PathVariable UUID usuarioId) {
        return ResponseEntity.ok(transaccionServicio.obtenerHistorialUsuario(usuarioId));
    }
}