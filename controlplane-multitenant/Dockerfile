FROM amazoncorretto:17.0.11

WORKDIR /app

EXPOSE 8080
COPY build/libs/app.jar controlplane-multitenant.jar
ENTRYPOINT exec java -jar controlplane-multitenant.jar