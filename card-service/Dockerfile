FROM openjdk:11
VOLUME /tmp
ADD target/bank-service-card-0.0.1-SNAPSHOT.jar service-card.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-card.jar"]