package com.example.finanzasbackend.modulos.deuda;

import com.example.finanzasbackend.modulos.deuda.dto.CrearDeudaDTO;
import com.example.finanzasbackend.modulos.deuda.dto.DeudaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/deudas")
@RequiredArgsConstructor
public class DeudaControlador {

    private final DeudaServicio deudaServicio;

    @PostMapping
    public ResponseEntity<DeudaDTO> crearDeuda(@RequestBody CrearDeudaDTO dto) {
        return new ResponseEntity<>(deudaServicio.crearDeuda(dto), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<DeudaDTO>> obtenerDeudas(@PathVariable UUID usuarioId) {
        return ResponseEntity.ok(deudaServicio.obtenerDeudasPorUsuario(usuarioId));
    }
}