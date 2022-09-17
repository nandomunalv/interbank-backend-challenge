# Interbank Backend Challenge

Este proyecto es el desarrollo de un par de servicios, los cuales son: para la consulta y actualización de un cliente. 
Los datos están almacenados en una base de datos en memoria (H2Db Engine) y está desarrollado con Spring Boot.


## Comenzamos 🚀

### Pre-requisitos 📋
Antes de iniciar con la clonación del proyecto, deberás tener las siguientes herramientas instaladas en tu ordenador:

* OpenJDK 1.8 - [descargar](https://adoptium.net/es/temurin/releases/?version=8)
* Git - [descargar](https://git-scm.com/)
* Postman - [descargar](https://www.postman.com/downloads/)
* IntelliJ (Opcional) - [descargar](https://www.jetbrains.com/es-es/idea/download/)


### Instalación 🔧
Una vez tengamos los **pre-requisitos** completos, abrimos una terminal y clonamos el proyecto en la carpeta de tu
preferencia.

> Como guía, se puede elaborar la siguiente ruta: **D:/Projects/github** y dentro de ella clonar este proyecto.

Ejecutamos el siguiente comando:
```
> git clone https://github.com/nandomunalv/interbank-backend-challenge.git
```

Ya clonado, abrimos el proyecto en nuestra IDE de preferencia e iniciamos el proyecto.

## Aquí los Endpoints ⚙

```
GET
> http://localhost:9090/api/customer/53506daf

PUT
> http://localhost:9090/api/customer/1
Body
{
  "codigoUnico": "53506daf",
  "nombres": "Arvin Kool",
  "apellidos": "Bryhn Kool",
  "tipoDocumento": "DNI",
  "numeroDocumento": "75067701"
}
```


## Construido con 🛠️

* [OpenJDK 8](https://adoptium.net/es/temurin/releases/?version=8) - The place to collaborate on an open-source implementation of the Java Platform, Standard Edition, and related projects.
* [Spring Boot 2.7.3](https://start.spring.io/) - With Spring Boot in your app, just a few lines of code is all you need to start building services like a boss.

## Autores ✒️

* **Fernando Muñoz Alvarez** - *Backend Developer* - [nandomunalv](https://github.com/nandomunalv)

## Expresiones de Gratitud 🎁

* Invita una cerveza 🍺 o un café ☕.
* Abrir un issue 📢 para ayudar a mejorar el proyecto
* Da las gracias 🤓.
