package com.example.finanzasbackend.modulos.categoria;

import com.example.finanzasbackend.modulos.categoria.dto.CategoriaDTO;
import com.example.finanzasbackend.modulos.categoria.dto.CrearCategoriaDTO;
import com.example.finanzasbackend.modulos.usuario.UsuarioEntidad;
import com.example.finanzasbackend.modulos.usuario.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaServicio {

    private final CategoriaRepositorio categoriaRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public CategoriaDTO crearCategoria(CrearCategoriaDTO dto) {
        UsuarioEntidad usuario = usuarioRepositorio.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        CategoriaEntidad nuevaCategoria = CategoriaEntidad.builder()
                .usuario(usuario)
                .nombre(dto.nombre())
                .tipoCategoria(dto.tipoCategoria())
                .icono(dto.icono())
                .colorHex(dto.colorHex())
                .build();

        return mapearADTO(categoriaRepositorio.save(nuevaCategoria));
    }

    public List<CategoriaDTO> obtenerCategoriasPorUsuario(UUID usuarioId) {
        return categoriaRepositorio.findByUsuarioId(usuarioId).stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private CategoriaDTO mapearADTO(CategoriaEntidad entidad) {
        return new CategoriaDTO(entidad.getId(), entidad.getNombre(), entidad.getTipoCategoria(), entidad.getIcono(), entidad.getColorHex());
    }
}