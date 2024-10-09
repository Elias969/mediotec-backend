# Use a imagem base do OpenJDK
FROM openjdk:23-jdk-slim

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo JAR gerado para o contêiner
COPY target/alunos-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que sua aplicação usará
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
