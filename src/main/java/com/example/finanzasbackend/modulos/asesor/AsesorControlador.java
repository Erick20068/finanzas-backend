package com.example.finanzasbackend.modulos.asesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/asesor")
public class AsesorControlador {

    @Autowired
    private AsesorServicio asesorServicio;

    @PostMapping
    public ResponseEntity<Map<String, String>> consultar(@RequestBody Map<String, Object> body) {
        // Llamamos al servicio de IA
        String respuestaIA = asesorServicio.consultarIA(body);
        
        // Devolvemos el JSON que el frontend de React espera: { "respuesta": "texto..." }
        Map<String, String> response = new HashMap<>();
        response.put("respuesta", respuestaIA);
        
        return ResponseEntity.ok(response);
    }
}