FROM maven:3.9.2-adoptopenjdk-19 AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM adoptopenjdk:19
WORKDIR /app
COPY --from=builder /build/target/SeaBattle-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
