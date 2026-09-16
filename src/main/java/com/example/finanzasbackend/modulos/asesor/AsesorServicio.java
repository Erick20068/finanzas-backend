package com.example.finanzasbackend.modulos.asesor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AsesorServicio {

    @Value("${groq.api.key}")
    private String groqApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String consultarIA(Map<String, Object> payload) {
        // 1. Extraer los datos enviados desde el frontend (React)
        String prompt = (String) payload.get("prompt");
        Map<String, Object> contexto = (Map<String, Object>) payload.getOrDefault("contexto", new HashMap<>());
        List<Map<String, String>> historial = (List<Map<String, String>>) payload.getOrDefault("historial", new ArrayList<>());

        // 2. Armar el mensaje de Sistema (El cerebro del asesor)
        String systemContent = String.format(
            "Eres un asesor financiero personal experto, empático pero directo. " +
            "INFO DEL USUARIO ESTE MES: Ingresos: $%s | Gastos: $%s. " +
            "Presupuestos: %s. Deudas: %s. " +
            "Da máximo 3 consejos claros, cortos y accionables en texto plano.",
            contexto.get("ingresos"), contexto.get("gastos"), 
            contexto.get("presupuestos"), contexto.get("deudas")
        );

        // 3. Unir todo el historial de la conversación
        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "system", "content", systemContent)); // Instrucciones
        messages.addAll(historial);                                       // Memoria
        messages.add(Map.of("role", "user", "content", prompt));          // Nuevo mensaje

        // 4. Preparar el cuerpo de la petición para Groq
        Map<String, Object> groqBody = new HashMap<>();
        groqBody.put("model", "llama3-8b-8192"); // Puedes cambiarlo por "openai/gpt-oss-120b" si Groq lo soporta
        groqBody.put("messages", messages);
        groqBody.put("temperature", 0.7);
        groqBody.put("max_tokens", 2048);

        // 5. Preparar los Headers con tu llave secreta
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(groqApiKey);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(groqBody, headers);

        try {
            // 6. Hacer la petición a la API de Groq
            ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://api.groq.com/openai/v1/chat/completions", 
                requestEntity, 
                Map.class
            );

            // 7. Extraer y devolver solo el texto de la respuesta
            Map<String, Object> responseBody = response.getBody();
            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
            
            return (String) message.get("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "Lo siento, tuve un problema conectándome a mi cerebro financiero. Intenta de nuevo más tarde.";
        }
    }
}