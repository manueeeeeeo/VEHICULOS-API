# API de Marcas y Modelos de Coches y Motos

Este proyecto es una API RESTful desarrollada con **Spring Boot** que permite gestionar y consultar marcas y modelos de coches y motos. Es útil para obtener información sobre diferentes vehículos, incluyendo las marcas y los modelos disponibles.

## Características

- **Gestión de marcas**: Permite agregar, eliminar, actualizar y consultar marcas de coches y motos.
- **Gestión de modelos**: Permite agregar, eliminar, actualizar y consultar modelos asociados a cada marca.
- **Tecnologías utilizadas**:
  - **Spring Boot**: Para crear la API RESTful.
  - **JPA/Hibernate**: Para gestionar la base de datos.
  - **Base de datos**: Utiliza H2 (por defecto) o cualquier base de datos relacional.
  - **Swagger**: Para generar una documentación interactiva de la API.

## Requisitos

- Java 17 o superior
- Maven o Gradle (dependiendo de la configuración del proyecto)
- Una base de datos (H2 está configurada por defecto, pero puedes usar MySQL, PostgreSQL, etc.)

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tuusuario/repositorio.git
2. Ingresa al directorio del proyecto:
   
    ```bash
    cd repositorio
4. Si usas Maven / Si usas Gradle, ejecuta:
   
    ```bash
    mvn spring-boot:run
    mvn spring-boot:run
4. La API debería estar disponible en http://localhost:8083.

## ENDPOINTS
Para obtener marcas de coches
/api/marcas/coches
Para obtener marcas de motos
/api/marcas/motos
Para obtener los modelos de una marca de coche en especial
/api/modelos/coches?marca=Kia
Para obtener los modelos de una marca de moto en especial
/api/modelos/motos?marca=Zontes
