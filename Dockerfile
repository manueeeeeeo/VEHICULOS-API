# Imagen base de Java
FROM openjdk:17-jdk-slim

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos los archivos del proyecto al contenedor
COPY . .

# Descargar y construir el .jar con Maven
RUN apt-get update && apt-get install -y maven && mvn clean package -DskipTests

# Exponer el puerto que usas
EXPOSE 8083

# Ejecutar el jar generado
CMD ["java", "-jar", "target/vehiculos-api-0.0.1-SNAPSHOT.jar"]