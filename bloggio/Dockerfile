FROM maven:3.6.0-jdk-11 AS build
WORKDIR /home/app
COPY . .

RUN ["ls"]

RUN mvn clean install

FROM openjdk:11

COPY --from=build /home/app/bloggioApp/target/bloggioApp-0.0.1-SNAPSHOT.jar /usr/local/lib/bloggioApp.jar

ENTRYPOINT ["java", "-jar","/usr/local/lib/bloggioApp.jar"]

EXPOSE 8083