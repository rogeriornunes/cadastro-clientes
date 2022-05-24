FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/cadastro-clientes.jar
WORKDIR /app
ENTRYPOINT java -jar cadastro-clientes.jar
