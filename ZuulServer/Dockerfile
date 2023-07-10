FROM maven:3.6.0-jdk-11 AS build
WORKDIR /home/app
COPY . .

RUN ["ls"]

RUN mvn -f /home/app/ZuulServer/pom.xml clean package


FROM openjdk:11

ENV PORT=8111

COPY --from=build /home/app/ZuulServer/target/*.jar /usr/local/lib/zuulserver.jar

ENTRYPOINT ["java", "-jar","/usr/local/lib/zuulserver.jar"]

EXPOSE 8111