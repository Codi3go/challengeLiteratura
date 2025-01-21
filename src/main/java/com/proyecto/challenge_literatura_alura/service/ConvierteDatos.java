package com.proyecto.challenge_literatura_alura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public <T> T obtenerDatos(String json, Class<T> clase) {
        if (json == null) {
            System.err.println("ERROR: JSON es nulo");
            throw new RuntimeException("La respuesta de la API es nula");
        }

        if (json.trim().isEmpty()) {
            System.err.println("ERROR: JSON está vacío");
            throw new RuntimeException("La respuesta de la API está vacía");
        }

        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            System.err.println("Contenido del JSON problemático:");
            System.err.println(json);
            e.printStackTrace();
            throw new RuntimeException("Error al procesar JSON", e);
        }
    }
}

