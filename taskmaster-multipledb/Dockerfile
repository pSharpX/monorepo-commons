FROM amazoncorretto:17.0.11

WORKDIR /app

EXPOSE 8080
COPY build/libs/app.jar taskmaster-multipledb.jar
ENTRYPOINT exec java -jar taskmaster-multipledb.jar