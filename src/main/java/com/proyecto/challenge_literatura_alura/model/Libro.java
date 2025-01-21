package com.proyecto.challenge_literatura_alura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String tema;
    private String idioma;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_autor")
    private Autor autor;

    public Libro(){};

    public Libro(DatosLibro datosLibro)
    {
        this.titulo = datosLibro.titulo();
        this.tema = datosLibro.temas().get(0);
        this.idioma = datosLibro.idiomas().get(0);
        if(datosLibro.autores() != null && !datosLibro.autores().isEmpty())
        {
            this.autor = new Autor(datosLibro.autores().get(0));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return
                ", titulo='" + titulo + '\'' +
                ", tema='" + tema + '\'' +
                ", idioma='" + idioma + '\'' +
                ", autor=" + autor;
    }
}