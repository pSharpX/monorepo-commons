FROM amazoncorretto:17.0.11

WORKDIR /app

EXPOSE 8080
COPY build/libs/app.jar encryptor-decryptor.jar
ENTRYPOINT exec java -jar encryptor-decryptor.jar