package com.example.finanzasbackend.modulos.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity<List<UsuarioEntidad>> listarUsuarios() {
        return ResponseEntity.ok(usuarioServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntidad> obtenerUsuarioPorId(@PathVariable UUID id) {
        return usuarioServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioEntidad> crearUsuario(@RequestBody UsuarioEntidad usuario) {
        UsuarioEntidad nuevoUsuario = usuarioServicio.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntidad> actualizarUsuario(@PathVariable UUID id, @RequestBody UsuarioEntidad usuarioDetalles) {
        try {
            UsuarioEntidad actualizado = usuarioServicio.actualizarUsuario(id, usuarioDetalles);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable UUID id) {
        try {
            usuarioServicio.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}