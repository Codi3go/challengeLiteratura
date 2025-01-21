package com.proyecto.challenge_literatura_alura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;
import java.util.ArrayList;

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int anioNacimiento,
        @JsonAlias("death_year") int anioMuerte
) {}
