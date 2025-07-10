# Etapa 1: build con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /usr/src/app

# Copia solo lo necesario para aprovechar cache
COPY pom.xml .
COPY src ./src

# Compilar sin tests para más rápido en Docker
RUN mvn clean package -DskipTests

# Etapa 2: imagen final
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /opt/app

ARG JAR_FILE=tp-3-redis-cache.jar

COPY --from=build /usr/src/app/target/${JAR_FILE} /opt/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "tp-3-redis-cache.jar"]
