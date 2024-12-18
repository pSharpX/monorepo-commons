# tm-email-notifier-consumer

## Introduction
The tm-email-notifier-consumer project contains all services for consuming and processing EMAIL notifications from publishers.

## Getting Started
## 1. Configure Broker
Install docker and from docker hub pull one of the following supported brokers:

### 1.1 kafka
Pull apache/kafka image (apache/kafka:latest), start kafka container and test the connection
https://hub.docker.com/r/apache/kafka

Pull apache/kafka:latest image from Docker Hub
```
docker pull apache/kafka:latest
```
Run a container
```
docker run -d -p 9092:9092 --name broker apache/kafka:latest
podman run -d -p 9092:9092 --name broker apache/kafka:latest
``` 
Open a shell in the broker container:
```
docker exec --workdir /opt/kafka/bin/ -it broker sh
podman exec --workdir /opt/kafka/bin/ -it broker sh
```
A topic is a logical grouping of events in Kafka. From inside the container, create a topic called test-topic:
```
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic test-topic
```
To list topics in a kafka cluster run the following command in the container:
```
./kafka-topics.sh --bootstrap-server localhost:9092 --list
```
Write two string events into the test-topic topic using the console producer that ships with Kafka:
```
./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test-topic
```
This command will wait for input at a > prompt. Enter hello, press Enter, then world, and press Enter again. Enter Ctrl+C to exit the console producer.

Now read the events in the test-topic topic from the beginning of the log:
```
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic TASK_MASTER_NOTIFICATIONS --from-beginning
```
Download the project from the GitHub repo, get a copy from the src/main/resources/application.properties.template for local use and put in /src/main/resources.

In the application.properties modify these properties as needed to match your kafka configuration:
``` 
task-master.notification.kafka.bootstrap.servers=localhost:9092
```

### 1.2 GCP PubSub
[Spring Cloud GCP PubSub Documentation](https://googlecloudplatform.github.io/spring-cloud-gcp/3.1.0/reference/html/index.html#cloud-pubsub)

#### 1.2.1 Running PubSub in Local Environment using emulator
[PubSub Local Emulator](https://medium.com/google-cloud/use-pub-sub-emulator-in-minikube-67cd1f289daf)

TBD

#### 1.2.2 Provision Cloud PubSub in GCP

Create a topic in GCP PubSub and include a subscription. 

Download the project from the GitHub repo, get a copy from the src/main/resources/application.properties.template for local use and put in /src/main/resources.

In the application.properties modify these properties as needed to match your configuration:
``` 
task-master.notification.pubsub.projectId=
task-master.notification.pubsub.subscriptionId=
task-master.notification.pubsub.serviceAccountKeyPath=classpath:<*-sa.json>
```

## 2. Configure Email Provider
For sending emails notifications the following integrations are supported:

### 2.1 MailChimp
For MailChimp Transactional API integration review the following documentation:
[MailChimp Transactional API](https://mailchimp.com/developer/transactional/guides/quick-start/)

These are the requirements:
- Mailchimp Account
- API Key

Once account is setup properly configure the following properties:
``` 
task-master.channel.email.mailchimp.url=https://mandrillapp.com
task-master.channel.email.mailchimp.apiVersion=/api/1.0
task-master.channel.email.mailchimp.basePath=${task-master.channel.email.mailchimp.url}${task-master.channel.email.mailchimp.apiVersion}
task-master.channel.email.mailchimp.apikey=
task-master.channel.email.mailchimp.config.mergeLanguage=handlebars
task-master.channel.email.mailchimp.from.email=
task-master.channel.email.mailchimp.from.name=
```

### 2.2 Twilio SendGrid
For MailChimp Transactional API integration review the following documentation:
[SendGrid API v3](https://www.twilio.com/docs/sendgrid/api-reference/mail-send/mail-send)

These are the requirements:
- SendGrid Account
- [API Key](https://app.sendgrid.com/login?redirect_to=%2Fsettings%2Fapi_keys)

Once account is setup properly configure the following properties:
``` 
task-master.channel.email.sendgrid.url=https://api.sendgrid.com
task-master.channel.email.sendgrid.apiVersion=/v3
task-master.channel.email.sendgrid.basePath=${task-master.channel.email.sendgrid.url}${task-master.channel.email.sendgrid.apiVersion}
task-master.channel.email.sendgrid.apikey=
task-master.channel.email.sendgrid.from.email=
task-master.channel.email.sendgrid.from.name=
```

### 2.3 Mailgun
TBD
### 2.4 Mailjet
TBD

Do not upload the local version of the application.properties to the repository. Add to .gitignore file.

### Build and Test
For building and running test:
```
./gradlew test build
```

For starting the app with the debug enabled:
```
./gradlew bootRun -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5050"
```

For running sonarqube (first install sonarqube in docker, and generate a token):
```
./gradlew clean test sonarqube -Dsonar.projectKey=onebank_controlplane -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<your_token>
```

### Additional Notes

Fix gradlew permission issue:
```
git update-index --chmod=+x gradlew
```