# 1️⃣ Use official Maven image to build the Java app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the app (skip tests for faster build)
RUN mvn clean package -DskipTests

# 2️⃣ Use a smaller JRE image for runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (example 8080)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
