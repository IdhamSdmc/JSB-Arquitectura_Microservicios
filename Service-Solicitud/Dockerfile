FROM openjdk:11
ADD "./build/libs/service-solicitud-0.0.1-SNAPSHOT.jar" "ms-solicitud.jar"
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "/ms-solicitud.jar"]