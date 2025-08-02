# Etapa 1: build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 as builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: imagem final mínima
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]