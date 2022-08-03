FROM openjdk:11
VOLUME /tmp
EXPOSE 8090
ADD target/bank-service-gateway-0.0.1-SNAPSHOT.jar gateway-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-service.jar"]