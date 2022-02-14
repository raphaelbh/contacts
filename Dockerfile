FROM openjdk:latest

WORKDIR /app

COPY ./app /app

RUN ./mvnw clean package

CMD ["java", "-jar", "target/contacts-0.0.1-SNAPSHOT.jar"]