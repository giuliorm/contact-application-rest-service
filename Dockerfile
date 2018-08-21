FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/contact-application-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} cas.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cas.jar"]