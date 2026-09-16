package com.example.finanzasbackend.modulos.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public List<UsuarioEntidad> obtenerTodos() {
        return usuarioRepositorio.findAll();
    }

    public Optional<UsuarioEntidad> obtenerPorId(UUID id) {
        return usuarioRepositorio.findById(id);
    }

   public UsuarioEntidad guardarUsuario(UsuarioEntidad usuario) {
    if (usuario.getId() == null) {
        throw new IllegalArgumentException("El id (UUID de Supabase Auth) es obligatorio");
    }
    if (usuario.getCorreo() == null || usuario.getCorreo().isBlank()) {
        throw new IllegalArgumentException("El correo es obligatorio");
    }
    if (usuario.getNombreCompleto() == null || usuario.getNombreCompleto().isBlank()) {
        throw new IllegalArgumentException("El nombre completo es obligatorio");
    }
    if (usuario.getMonedaPreferida() == null || usuario.getMonedaPreferida().isBlank()) {
        usuario.setMonedaPreferida("USD");
    }

    return usuarioRepositorio.findById(usuario.getId())
            .map(existente -> {
                existente.setNombreCompleto(usuario.getNombreCompleto());
                existente.setCorreo(usuario.getCorreo());
                existente.setMonedaPreferida(usuario.getMonedaPreferida());
                return usuarioRepositorio.save(existente);
            })
            .orElseGet(() -> usuarioRepositorio.save(usuario));
}

    public UsuarioEntidad actualizarUsuario(UUID id, UsuarioEntidad detallesUsuario) {
        UsuarioEntidad usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        usuario.setNombreCompleto(detallesUsuario.getNombreCompleto());
        usuario.setCorreo(detallesUsuario.getCorreo());
        usuario.setMonedaPreferida(detallesUsuario.getMonedaPreferida());

        return usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(UUID id) {
        usuarioRepositorio.deleteById(id);
    }
}