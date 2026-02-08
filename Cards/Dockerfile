FROM ubuntu:latest
WORKDIR /app
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH
COPY target/Cards-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8087

CMD ["java" , "-jar" , "app.jar"]

