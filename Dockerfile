FROM amazoncorretto:23.0.2

COPY target/free_mind-0.0.1-SNAPSHOT.jar /app/api-freemind-v1.jar

ENTRYPOINT ["java", "-jar", "/app/api-freemind-v1.jar"]