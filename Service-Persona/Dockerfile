FROM openjdk:11
ADD "./build/libs/service-persona-0.0.1-SNAPSHOT.jar" "ms-persona.jar"
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/ms-persona.jar"]