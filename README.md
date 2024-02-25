# Proyecto con Github Actions

Este proyecto demuestra el uso de GitHub Actions en una aplicación Java con Maven.

## Descripción

La aplicación permite registrar fallas con diferentes niveles de gravedad. Los registros se guardan en un archivo JSON mediante la clase [`RegistroService`](src/main/java/com/app/githubactions/RegistroService.java).

## Instalación

Para instalar el proyecto, necesitas tener instalado Java 17 y Maven. Luego, puedes clonar el repositorio y usar Maven para construir el proyecto:

```sh
git clone <url del repositorio>
cd <directorio del repositorio>
./mvnw clean install
