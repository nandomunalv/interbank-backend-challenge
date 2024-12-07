# Etapa 1: Compilar el proyecto
FROM maven:3.6.3-jdk-8 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el código fuente al contenedor
COPY . /app

# Ejecuta el build de Maven para crear el paquete
RUN mvn clean package -Dmaven.test.skip=true -Djacoco.skip=true

# Etapa 2: Ejecutar la aplicación
FROM openjdk:8-jdk-slim

# Copia el archivo JAR desde la etapa de build
COPY --from=build /app/target/reto-backend-interbank-0.0.1-SNAPSHOT.jar /app/reto-backend-interbank.jar

# Establece el directorio de trabajo
WORKDIR /app

# Expone el puerto que usa la aplicación
EXPOSE 9090

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "reto-backend-interbank.jar"]
