# Utiliza a imagem base do OpenJDK 8
FROM openjdk:8-jdk-slim as build

# Copia os arquivos locais para o contêiner
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Garante que mvnw tenha permissão de execução
RUN chmod +x mvnw

# Constrói a aplicação usando Maven
RUN ./mvnw package -DskipTests

# Empacota a aplicação com uma imagem OpenJDK Slim
FROM openjdk:8-slim
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação utiliza
EXPOSE 8080

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]