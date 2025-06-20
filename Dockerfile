FROM openjdk:21

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR al directorio de trabajo
COPY ./target/atm-0.0.1-SNAPSHOT.jar .

# Expone el puerto en el que tu aplicación escucha
EXPOSE 8080

# Comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "atm-0.0.1-SNAPSHOT.jar"]
