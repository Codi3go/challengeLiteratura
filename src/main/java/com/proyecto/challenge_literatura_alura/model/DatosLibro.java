package com.proyecto.challenge_literatura_alura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DatosLibro (
        @JsonAlias("title") String titulo,
        @JsonAlias("subjects") List<String> temas,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("authors") List<DatosAutor> autores
){}
