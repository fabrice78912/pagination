
# Step 1: Builder le projet avec maven
FROM maven:3.8.3-openjdk-17-slim AS maven-builder
WORKDIR /app
COPY . /app
RUN mvn -f pom.xml clean package -DskipTests
RUN mvn verify

# Step 2: Copier et lancer le .jar file
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=maven-builder ./app/target/pagination-app.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "pagination-app.jar"]
