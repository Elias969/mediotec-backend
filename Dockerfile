# Usar uma imagem base do Java 23
FROM openjdk:23-jdk-slim

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR gerado para o contêiner
COPY target/alunos-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta em que a aplicação irá rodar (substitua pela porta que sua aplicação usa, por padrão é 8080)
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
