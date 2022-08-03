FROM openjdk:11
VOLUME /tmp
EXPOSE 8040
ADD target/bank-cloud-config-server-0.0.1-SNAPSHOT.jar config-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-service.jar"]