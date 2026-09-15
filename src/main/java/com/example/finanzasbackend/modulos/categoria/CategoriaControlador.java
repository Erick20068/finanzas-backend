package com.example.finanzasbackend.modulos.categoria;

import com.example.finanzasbackend.modulos.categoria.dto.CategoriaDTO;
import com.example.finanzasbackend.modulos.categoria.dto.CrearCategoriaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaControlador {

    private final CategoriaServicio categoriaServicio;

    @PostMapping
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CrearCategoriaDTO dto) {
        return new ResponseEntity<>(categoriaServicio.crearCategoria(dto), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<CategoriaDTO>> obtenerCategorias(@PathVariable UUID usuarioId) {
        return ResponseEntity.ok(categoriaServicio.obtenerCategoriasPorUsuario(usuarioId));
    }
}