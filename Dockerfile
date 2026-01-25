FROM openjdk:25-ea-25-jdk-slim

MAINTAINER oussama

COPY target/micor-demo-0.0.1-SNAPSHOT.jar micor-demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","micor-demo-0.0.1-SNAPSHOT.jar"]



