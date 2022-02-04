FROM openjdk:11
COPY "./build/libs/registry-service-0.0.1-SNAPSHOT.jar" "registry-service.jar"
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/registry-service.jar"]