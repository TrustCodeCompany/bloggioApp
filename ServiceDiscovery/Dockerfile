FROM maven:3.6.0-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11

ENV PORT=8761

COPY --from=build /home/app/target/ServiceDiscovery-0.0.1-SNAPSHOT.jar /usr/local/lib/ServiceDiscovery.jar

ENTRYPOINT ["java", "-jar","/usr/local/lib/ServiceDiscovery.jar"]

EXPOSE 8761