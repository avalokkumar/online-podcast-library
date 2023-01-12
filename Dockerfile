FROM openjdk:11-jre-slim
COPY build/libs/online-podcast-library-0.0.1.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8084