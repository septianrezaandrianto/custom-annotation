FROM openjdk:21-jdk
ARG JAR_FILE=target/custom-handler-0.0.1-SNAPSHOT.jar
EXPOSE 8090
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]