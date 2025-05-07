# SISTEMA DE GESTIÓN DE PROYECTOS (SGP)

Este proyecto es una aplicación **Spring Boot 3.4.5** para gestionar proyectos y solicitudes financieras, con persistencia en MySQL y PostgreSQL.

## Índice

- [Descripción](#descripción)
- [Características Principales](#características-principales)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Dependencias Clave](#dependencias-clave)
- [Plugins de Build](#plugins-de-build)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Licencia](#licencia)

## Descripción

SGP es un sistema modular que utiliza:

- Spring Boot Data JPA para acceso a datos.
- Spring HATEOAS para navegar recursos REST.
- WebSocket para comunicación en tiempo real.
- Spring Security y OAuth2 para autenticación y autorización.
- JSON Web Tokens (JJWT) para manejo de tokens.

## Características Principales

- Modelos basados en JPA para **Users**, **Proyectos**, **Solicitudes** y más.
- Validación de entrada con Jakarta Validation.
- API RESTful con HATEOAS.
- Soporte de WebSocket para notificaciones.
- Configuración multibase de datos (MySQL y PostgreSQL).

## Requisitos

- Java 21
- Maven 3.6+
- MySQL 8+ (o PostgreSQL 13+)
- Git

## Instalación

1. Clonar el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd sgp
   ```
2. Configurar conexión a BD en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/sgp
   spring.datasource.username=root
   spring.datasource.password=secret

   spring.datasource.postgresql.url=jdbc:postgresql://localhost:5432/sgp
   spring.datasource.postgresql.username=postgres
   spring.datasource.postgresql.password=secret
   ```
3. Construir el proyecto:
   ```bash
   mvn clean package
   ```

## Uso

Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

La API quedará disponible en `http://localhost:8080/api`.

## Dependencias Clave

- **Spring Boot Starter Data JPA**: Mapeo objeto-relacional.
- **Spring Boot Starter Web**: Construcción de endpoints REST.
- **Spring Boot Starter WebSocket**: Soporte WebSocket.
- **Spring Boot Starter Security & OAuth2 Client**: Seguridad y OAuth2.
- **JJWT (0.11.5)**: Biblioteca JWT.
- **ModelMapper (3.0.0)**: Mapeo de DTOs.
- **MySQL Connector/J**: Driver MySQL.

## Plugins de Build

- **maven-compiler-plugin**: Soporte de Lombok para anotaciones.
- **spring-boot-maven-plugin**: Empaquetado ejecutable, excluye Lombok.

## Estructura del Proyecto

```
src/
├─ main/
│  ├─ java/com/diocesisdecarupano/sgp
│  │   ├─ modules/     # Módulos por dominio (user, project, solicitud, etc.)
│  │   └─ shared/      # Infraestructura y utilidades comunes
│  └─ resources/
│      ├─ application.properties
│      └─ static/, templates/
└─ test/
```

## Licencia

Este proyecto está licenciado bajo [MIT License]().