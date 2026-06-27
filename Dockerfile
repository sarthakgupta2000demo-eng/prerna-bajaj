FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/bfhl-0.0.1-SNAPSHOT.jar"]