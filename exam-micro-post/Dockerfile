FROM java:8-jdk-alpine
MAINTAINER maribel.barrerat@elektra.com.mx
COPY ${JAR_FILE} app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]