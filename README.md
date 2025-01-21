# challengeLiteratura


## Descripción

El proyecto es una aplicación de consola desarrollada con Spring Boot que utiliza PostgreSQL para gestionar libros y autores. Permite buscar libros, listar autores, filtrar por idioma, y más.

## Funcionalidades

- Buscar y guardar libros desde una API externa.
- Mostrar libros y autores registrados.
- Filtrar autores fallecidos después de un año específico.
- Filtrar libros por idioma.
- Generar estadísticas de descargas.
- Listar los 10 libros más descargados.
- Buscar autores por nombre.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.3.2-SNAPSHOT
- PostgreSQL
- Maven
- Lombok
- JPA / Hibernate
- Jackson
- Jansi

```markdown
## Instalación

1. Clona el repositorio:
   
   git clone https://github.com/Codi3go/challengeLiteratura.git
   cd 03_Literatura
   

2. Configura las credenciales de la base de datos en `application.properties`:
   
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

3. Compila el proyecto:
   ```
   mvn clean install
   ```

4. Ejecuta la aplicación:
   ```
   mvn spring-boot:run
   ```

## Uso

El menú de la aplicación ofrece las siguientes opciones:

1. Buscar libro por título  
2. Listar libros registrados  
3. Listar autores registrados  
4. Listar autores vivos en un año determinado  
5. Listar libros por idioma  
6. Generar estadísticas del número de descargas  
7. Listar el top 10 de libros más descargados  
8. Buscar autor por nombre  
9. Salir  

Selecciona la opción deseada ingresando el número correspondiente.

## Contribuciones

Las contribuciones son bienvenidas. Envía una pull request con tus ideas.

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE.md).
```
