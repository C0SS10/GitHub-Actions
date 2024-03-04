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
```

> [!TIP]
> * * * * *
>│ │ │ │ │
>│ │ │ │ │
>│ │ │ │ └──── Día de la semana (0 - 7) (Domingo es 0 o 7)
>│ │ │ └────── Mes (1 - 12)
>│ │ └──────── Día del mes (1 - 31)
>│ └────────── Hora (0 - 23)
>└──────────── Minuto (0 - 59)
