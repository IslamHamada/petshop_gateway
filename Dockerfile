FROM eclipse-temurin:17-jdk

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} gateway.jar

ENTRYPOINT ["java", "-jar", "gateway.jar"]

EXPOSE 9090