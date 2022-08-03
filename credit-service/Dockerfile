FROM openjdk:11
VOLUME /tmp
ADD target/bank-service-credit-0.0.1-SNAPSHOT.jar credit-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/credit-service.jar"]