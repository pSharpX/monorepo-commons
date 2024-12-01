FROM amazoncorretto:17.0.11

WORKDIR /app

EXPOSE 8080
COPY build/libs/app.jar async-handler.jar
ENTRYPOINT exec java -jar async-handler.jar