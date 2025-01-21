package com.proyecto.challenge_literatura_alura;

import com.proyecto.challenge_literatura_alura.model.ApiResponse;
import com.proyecto.challenge_literatura_alura.model.Autor;
import com.proyecto.challenge_literatura_alura.model.DatosLibro;
import com.proyecto.challenge_literatura_alura.model.Libro;
import com.proyecto.challenge_literatura_alura.repository.AutorRepository;
import com.proyecto.challenge_literatura_alura.repository.LibroRepository;
import com.proyecto.challenge_literatura_alura.service.ConsumoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class Aplicacion {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private ConsumoAPI consumoAPI = new ConsumoAPI();

    public void iniciar()
    {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("Ingrese una opcion:");
            System.out.println();
            System.out.println("1. Buscar libro por titulo");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");

            opcion = sc.nextInt();

            System.out.println();

            switch(opcion)
            {
                case 1:
                {
                    System.out.print("Ingrese el titulo del libro a buscar: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();

                    String url = "http://gutendex.com/books/?search=" + URLEncoder.encode(nombre, StandardCharsets.UTF_8)
                            + "&page_size=1&page=1";

                    ApiResponse apiResponse = consumoAPI.obtenerDatos(url, ApiResponse.class);

                    if (apiResponse != null && apiResponse.resultados() != null && !apiResponse.resultados().isEmpty())
                    {
                        ArrayList<DatosLibro> datosLibros = new ArrayList<>(apiResponse.resultados());

                        DatosLibro datosLibro = datosLibros.get(0);

                        Libro libro = new Libro(datosLibro);

                        if (libro.getAutor() != null)
                        {
                            Autor autorExistente = autorRepository.findByNombre(libro.getAutor().getNombre());

                            if (autorExistente != null)
                            {
                                libro.setAutor(autorExistente);
                            }
                        }

                        libroRepository.save(libro);
                    }
                    else
                    {
                        System.out.println("No se encontraron libros.");
                    }
                    break;
                }
                case 2:
                {
                    libroRepository.findAll().forEach(System.out::println);
                    break;
                }
                case 3:
                {
                    autorRepository.findAll().forEach(System.out::println);
                    break;
                }
                case 4:
                {
                    System.out.print("Ingrese el anio a buscar:");
                    int anio = sc.nextInt();

                    autorRepository.findByAnio(anio).forEach(System.out::println);
                    break;
                }
                case 5:
                {
                    sc.nextLine();
                    System.out.print("Ingrese el idioma a buscar:");
                    String idioma = sc.nextLine();

                    libroRepository.findByIdioma(idioma).forEach(System.out::println);
                    break;
                }
                case 6:
                {
                    System.out.println("Gracias por usar el sistema");
                    break;
                }
                default:
                {
                    System.out.println("Opcion invalida");
                }
            }
        }
        while(opcion != 6);
    }
}