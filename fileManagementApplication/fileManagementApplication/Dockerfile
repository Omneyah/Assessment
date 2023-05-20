FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} fileManagementApp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/fileManagementApp.jar"]