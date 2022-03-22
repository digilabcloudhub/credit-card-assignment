FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} creditcard.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/creditcard.jar"]