FROM adoptopenjdk:11-jdk-hotspot
ARG JAR_FILE=target/*.jar
COPY ./target/SeaBattle-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
