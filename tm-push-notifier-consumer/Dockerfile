FROM amazoncorretto:17.0.11

WORKDIR /app

EXPOSE 8080
COPY build/libs/app.jar tm-push-notifier-consumer.jar
ENTRYPOINT exec java -jar tm-push-notifier-consumer.jar