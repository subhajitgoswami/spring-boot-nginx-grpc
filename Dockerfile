FROM openjdk:8-jdk-alpine

# this is optional path where your app.jar will be kept 
WORKDIR /usr/app

ADD target/nginx*.jar app.jar

EXPOSE 8080

ENTRYPOINT java -jar app.jar