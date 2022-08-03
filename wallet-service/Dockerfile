FROM openjdk:11
VOLUME /tmp
ADD target/bank-service-wallet-0.0.1-SNAPSHOT.jar wallet-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wallet-service.jar"]