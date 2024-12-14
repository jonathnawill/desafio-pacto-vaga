# Etapa 1: Build da aplicação
FROM maven:3.8.6-openjdk-8 AS build

WORKDIR /app

# Copiar o pom.xml e src para o container
COPY pom.xml .
COPY src ./src

# Construir a aplicação (gera o .jar em target/)
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final com o JRE
FROM openjdk:8-jre-slim

WORKDIR /app

# Copiar o arquivo .jar gerado na etapa de build
COPY --from=build /app/target/pacto-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta usada pela aplicação
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]
