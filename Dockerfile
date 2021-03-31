# Use maven to compile the java application.
FROM adoptopenjdk:8-jdk-hotspot AS builder

# copy the pom.xml file to download dependencies
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew bootJar

# Build runtime image.
FROM adoptopenjdk:8-jdk-hotspot

# Copy the compiled files over.
COPY --from=builder build/libs/*.jar app.jar

# Starts java app with debugging server at port 5005.
CMD ["java", "-jar", "/app.jar"]
