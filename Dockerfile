FROM openjdk:17-jdk-slim

# Procedemos a copiar el archivo JAR de la API al contenedor
COPY target/vehiculos-api-0.0.1-SNAPSHOT.jar /app.jar

# Exponemos el puerto que usa Spring Boot
EXPOSE 8083

# Comando para ejecutar la API
ENTRYPOINT ["java", "-jar", "/app.jar"]
