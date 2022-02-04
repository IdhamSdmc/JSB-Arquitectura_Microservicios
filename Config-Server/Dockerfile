FROM openjdk:11
COPY "./build/libs/config-service-0.0.1-SNAPSHOT.jar" "config-service.jar"
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/config-service.jar"]