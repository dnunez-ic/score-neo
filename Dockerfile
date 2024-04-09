# Stage 1: Build the application
FROM maven:3.8.1-openjdk-17-slim AS MAVEN_BUILD

RUN mkdir /sources
COPY ./ /sources

RUN echo "Building app..." && cd /sources && mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-oracle

WORKDIR /app
COPY --from=MAVEN_BUILD /sources/target/score-neo-0.0.1-SNAPSHOT.jar /app/score-neo-0.0.1-SNAPSHOT.jar
EXPOSE 9000

CMD ["java","-jar","score-neo-0.0.1-SNAPSHOT.jar"]
