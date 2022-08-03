FROM openjdk:11
VOLUME /tmp
ADD target/bank-service-client-0.0.1-SNAPSHOT.jar client-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/client-service.jar"]