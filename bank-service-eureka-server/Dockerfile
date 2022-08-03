FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD target/bank-service-eureka-server-0.0.1-SNAPSHOT.jar eureka-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-service.jar"]