# spring-boot-nginx-grpc
[Spring Boot](http://projects.spring.io/spring-boot/) grpc with nginx proxy server and docker-compose

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Docker](https://www.docker.com)

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

## More detailed steps and information to help you run application in local
  * I am assuming you have below already installed in your machine
    * docker
	* Java 8 or above
	* maven 3+
	* any local java development tool(Intelij, Eclipse etc.)
	* git
	
  * check out the project:
  ```shell
   git clone https://github.com/subhajitgoswami/spring-boot-nginx-grpc.git
  ```
  * create proto files and jar using below command from project directory
  ```shell
   mvn clean install -DskipTests
  ```
  * You will have two service running in docker 1. Nginx 2. spring-boot:
  ```shell
   docker ps
  ```
  * Check the ip address of spring-boot service using docker inspect:
  ```shell
   docker inspect <container-id>
  ```
  * Use above ip in your nginx default.conf file for upstream grpcservers<port 9090 for grpc> and location proxy_pass<port 8080 for spring-boot> as in properties file
    upstream grpcservers {
    server 172.20.0.2:9090; 
     }
  * In default config file for nginx, location for Proto service will be in below format
    - /package.servicename/functionName.
	 
  * use the same grpc service address (172.20.0.2:9090) in PersonService.java in spring-boot service to call grpc-service.
  * In docker-compose.yaml file port mapping of service to nginx is done below
    ### service port: default nginx port
    - 8080:80
  * In docker-compose.yaml file, expose the service at port 8080
  * In docker-compose.yaml file, volume destination should be exactly the same as its the path where nginx stores its config
    ### source config path in project: destination nginx config
    - ./nginx/conf.d:/etc/nginx/conf.d
	 

