FROM amazoncorretto:17.0.11

WORKDIR /app

EXPOSE 8080
COPY build/libs/app.jar scheduler.jar
ENTRYPOINT exec java -jar scheduler.jar