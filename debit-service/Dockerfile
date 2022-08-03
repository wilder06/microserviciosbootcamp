FROM openjdk:11
VOLUME /tmp
ADD target/bank-service-debit-0.0.1-SNAPSHOT.jar debit-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/debit-service.jar"]