# Imagen base de Java (cambie el 17 por 21 si esa es su versión de Java)
FROM eclipse-temurin:17-jdk-alpine

# Define el directorio de trabajo interno
WORKDIR /app

# Copia los archivos de su proyecto al contenedor
COPY . .

# Otorga permisos al compilador Maven y construye la aplicación
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Expone el puerto por defecto de Spring Boot
EXPOSE 8080

# Ejecuta el archivo compilado
CMD ["sh", "-c", "java -jar target/*.jar"]