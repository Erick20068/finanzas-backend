package com.example.finanzasbackend.modulos.presupuesto;

import com.example.finanzasbackend.modulos.presupuesto.dto.CrearPresupuestoDTO;
import com.example.finanzasbackend.modulos.presupuesto.dto.PresupuestoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/presupuestos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") 
public class PresupuestoControlador {

    private final PresupuestoServicio presupuestoServicio;

    @PostMapping
    public ResponseEntity<PresupuestoDTO> crearPresupuesto(@RequestBody CrearPresupuestoDTO dto) {
        return new ResponseEntity<>(presupuestoServicio.registrarPresupuesto(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{usuarioId}/{anio}/{mes}")
    public ResponseEntity<List<PresupuestoDTO>> obtenerPresupuestosMensuales(
            @PathVariable UUID usuarioId,
            @PathVariable Integer anio,
            @PathVariable Integer mes) {
        return ResponseEntity.ok(presupuestoServicio.obtenerPresupuestosDelMes(usuarioId, mes, anio));
    }
}