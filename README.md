# BBDD--Redis-y-Cache
Este proyecto es una aplicación **Java Spring Boot** que implementa cache usando **Ehcache** y **Redis** para mejorar el rendimiento de las consultas de datos.


## Descripción

- **Aeropuertos**: Gestionados con **Ehcache**.
  - Operaciones disponibles:
    - Listar todos los aeropuertos.
    - Buscar un aeropuerto por `id`.
    - Crear un aeropuerto.
    - Modificar un aeropuerto existente.

- **Aviones**: Gestionados con **Redis**.
    - Listar todos los aviones
    - Buscar un avion por `ìd`.
    - Crear un avion.
    - Modificar un avion existente.

## Tecnologías usadas

- **Java 17**
- **Spring Boot 3.5**
- **Spring Data JPA**
- **PostgreSQL**
- **Ehcache**
- **Redis**
- **Maven**

## Configuración

La configuración de base de datos y caché se realiza en el archivo `application.properties`.  
Asegúrate de tener corriendo los siguientes servicios:
- **PostgreSQL** con la base de datos configurada.
- **Redis** para el almacenamiento de caché de Aviones.
- **EhCache** para el almacenamiento de cache de Aeropuertos

Ejemplo de configuración:
```properties
spring.datasource.url=jdbc:postgresql: direccion-bbdd
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Endpoints disponibles

| Recurso	|Método	|Endpoint	|Descripción|
|-----------|-------|-----------|-----------|
|Aeropuertos|	GET	|/aeropuertos |	Listar todos los aeropuertos|
|Aeropuertos|	GET	|/aeropuerto/{id} |	Obtener un aeropuerto por ID|
|Aeropuertos|	POST|	/aeropuerto	| Crear un aeropuerto|
|Aeropuertos|	PUT	|/aeropuerto	| Modificar un aeropuerto|
|Aviones	  |	GET | /avion      | Listar todos los aviones  |
|Aviones    | GET | /avion/{id} | Obtener un avion por ID|
|Aviones    | POST| /avion      | Crear un avion         |
|Aviones    | PUT | /avion      | Modificar un avion     |

### Ejemplo de Endpoint en POSTMAN


 > POST http:/localhost:8080/aeropuerto

En raw JSON
 ```
 {
    "nombre": ..nombre_aeropuerto,
    "ciudad": ..ciudad_aeropuerto,
    "pais": ..pais_aeropuerto
 }
```

Deberias crear un Aeropuerto

  > POST http:/localhost:8080/avion
En raw JSON
```
{
    "nombre": "'Boeing 737-800",
    "total_de_asientos": 251
}
```

## Cómo correrlo

### Configuracion local y entorno de Desarrollo

1. Clona el repositorio.

2.Configura la base de datos y Redis.

3. Ejecuta:

> mvn clean install
> mvn spring-boot:run
> Usa herramientas como Postman para probar los endpoints.

### Docker

1. Desde la terminal de tu navegador ir a la carpeta raiz del proyecto

2. Correr el siguiente comando.

> docker compose up --build

3. Pobrar endpoints con Postman o aplicaciones similares.
