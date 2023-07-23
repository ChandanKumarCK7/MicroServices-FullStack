FROM openjdk:11-jre-slim
copy ../../../. /app

workdir /app
FROM openjdk:11-jre-slim
COPY ../../../target/netflix-eureka-naming-server-0.0.1-SNAPSHOT.jar /app/eureka.jar
copy ./application.properties /app/application.properties
EXPOSE 8765
CMD ["java", "-jar", "eureka.jar"]