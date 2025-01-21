package com.proyecto.challenge_literatura_alura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record ApiResponse(
        int count,
        String next,
        String previous,
        @JsonAlias("results") List<DatosLibro> resultados
) {}