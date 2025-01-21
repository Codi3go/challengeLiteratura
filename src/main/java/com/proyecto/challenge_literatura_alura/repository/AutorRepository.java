package com.proyecto.challenge_literatura_alura.repository;

import com.proyecto.challenge_literatura_alura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.anioNacimiento <= :anio AND (a.anioMuerte IS NULL OR a.anioMuerte >= :anio)")
    List<Autor> findByAnio(@Param("anio") int anio);

}