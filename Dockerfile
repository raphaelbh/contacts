FROM openjdk:latest

WORKDIR /application

COPY ./application /application

RUN ./mvnw clean package

ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "target/contacts-0.0.1-SNAPSHOT.jar"]