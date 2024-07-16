# Proyecto Challenge LitelAlura Spring Boot con CommandLineRunner

Este proyecto es una aplicación de consola desarrollada en Spring Boot que interactúa con la API de Gutendex para realizar diversas operaciones relacionadas con libros y autores.
Utiliza PostgreSQL como base de datos y varias librerías para facilitar el desarrollo.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **PostgreSQL**
- **Librerías y Dependencias**:
  - `postgresql`
  - `jackson-databind`
  - `lombok`

## Instalación

1. **Clonar el repositorio**:
    ```bash
    git clone https://github.com/tuusuario/proyecto-springboot-commandlinerunner.git
    cd proyecto-springboot-commandlinerunner
    ```

2. **Configurar la base de datos**:
    - Crear una base de datos PostgreSQL.
    - Configurar las credenciales de la base de datos en el archivo `application.properties`.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/tu_basedatos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Construir y ejecutar la aplicación**:
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

## Uso
![image](https://github.com/user-attachments/assets/1c6aea11-bdff-409d-a1df-13d130413614)


Al ejecutar la aplicación, se presentará un menú en la consola con las siguientes opciones:

1. **Buscar libro por título**
    - Permite buscar un libro por su título en la API de Gutendex.
    - **Entrada**: Título del libro.
    - **Salida**: Información del libro encontrado.

2. **Mostrar todos los libros**
    - Muestra una lista de todos los libros disponibles en la base de datos local.
    
3. **Listar todos los autores**
    - Muestra una lista de todos los autores disponibles en la base de datos local.

4. **Mostrar autores vivos por determinado año**
    - Permite buscar autores que estaban vivos en un año específico.
    - **Entrada**: Año.
    - **Salida**: Lista de autores vivos en ese año.

5. **Buscar libro por idioma**
    - Permite buscar libros por su idioma en la base de datos local
    - **Entrada**: Código del idioma (por ejemplo, 'en' para inglés, 'es' para español).
    - **Salida**: Lista de libros en el idioma especificado.

0. **Salir**
    - Cierra la aplicación.

