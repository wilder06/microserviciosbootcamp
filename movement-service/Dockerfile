FROM openjdk:11
VOLUME /tmp
ADD target/bank-service-movement-0.0.1-SNAPSHOT.jar movement-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/movement-service.jar"]