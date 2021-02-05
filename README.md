# spring-boot-nginx-grpc
[Spring Boot](http://projects.spring.io/spring-boot/) grpc with nginx proxy server and docker-compose

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Build the application locally

- go to the project path in you machine and run:

```shell
mvn clean install
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.dev.nginx.grpc;.GrpcNginxApplication` class from your IDE
right click on the file and run as java application.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying using docker

The easiest way to deploy the  application to docker is to use the [Docker-compose](https://docs.docker.com/compose/compose-file/).Install docker for windows/linux/mac, run below steps
 * check docker version if installation is done 
 ```shell
  docker version
 ```
  * go to project directory and run below command  
 ```shell
  docker-compose up --build
 ```

## Access the application externally

Open your favourite browser and hit the URL:
 
 * check the localhost ip and corresponding DNS in local machine from hosts file under C:\Windows\System32\drivers\etc if local host doesn't work

```shell
<localhost-ip-in-hosts-file>:8080/sayHello
```


