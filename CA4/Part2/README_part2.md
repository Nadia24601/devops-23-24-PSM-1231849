 # CA4 - Part 2: Containers with Docker

 ## Introduction

In this part of the assignment, we will create two Dockerfiles, one for the H2 database and one for the Spring Boot application. We will also create a `docker-compose.yml` file to define the two services and build and run the Docker containers using Docker Compose. We will also access the H2 database console and use the settings to access the database file.

 ### 1. Change application properties to use H2 database

```properties
# Update application.properties to use H2 database
server.servlet.context-path=/api

spring.datasource.url=jdbc:h2:tcp://database:9092/~/data/devops
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=devops
spring.datasource.password=devops
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true
````


### 2. Create Dockerfile for H2 Database

Create a `Dockerfile_db` for the H2 database.

```
FROM gradle:jdk17 AS builder

WORKDIR /usr/src/devops/

ADD https://search.maven.org/remotecontent?filepath=com/h2database/h2/2.2.224/h2-2.2.224.jar h2.jar

EXPOSE 8082
EXPOSE 9092

# Using the H2 Shell 
# Create a new database called devops and create a new user called sa with password test
RUN ["java", "-cp", "h2.jar", "org.h2.tools.Shell", "-url",
 "jdbc:h2:~/data/devops", "-user", "devops", "-password", "devops"]

ENTRYPOINT ["java", "-cp", "h2.jar", "org.h2.tools.Server", "-web",
 "-webAllowOthers", "-tcp", "-tcpAllowOthers", "-ifNotExists"]
```

### 3. Create Dockerfile for Spring Boot Application

Create a `Dockerfile_web` for the  Spring Boot application.

```
FROM gradle:jdk17 AS builder

WORKDIR /usr/src/devops/

COPY CA2/Part2/react-and-spring-data-rest-basic/build .

EXPOSE 8080

ENTRYPOINT ["java","-jar","./libs/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.jar"]
```

### 4. Create `docker-compose.yml`

Create a `docker-compose.yml` file to define your two services: `web` and `db`.
````
services:
database:
build:
context: .
dockerfile: ./Dockerfile_db
ports:
- "8082:8082"
- "9092:9092"
    volumes:
      - ./db:/usr/src/dbbackup
env_file:
- common.env

web:
build:
context: ../../
dockerfile: CA4/Part2/Dockerfile_web
ports:
- "8080:8080"
env_file:
- common.env

`````

### 5. Build and Run 

Go to CA2/Part2/react-and-spring-data-rest-basic and run the following command to build the project.
    
````
./gradlew clean build

````

Build and run your Docker containers using Docker Compose.

```
docker-compose up --build
```

### 6. Access the Database File

Access the H2 database console at `http://localhost:8080/api` and use the following settings:
jdbc:h2:~/data/devops
user: username 
password: password

## Publich the images to Docker Hub
Firstly you need to tag the images. Then you can push the images to your Docker Hub repository.
docker tag part2-database nadia24601/devops-part2-db:latest
docker tag part2-web nadia24601/devops-part2-web:latest

Then you can push the Images to Docker Hub repositories:
docker push nadia24601/devops-part2-db:latest
docker push nadia24601/devops-part2-web:latest

### Create and use a volume for the database

Use a volume with the db container to get a copy of the database file by using the
exec to run a shell in the container and copying the database file to the volume.

Firstly run the services defined in the compose.yml:
```
docker-compose up -d
```
Access the shell of the database container:
```
docker-compose exec database bash
```
Then inside the container, copy the database file to the directory mounted to the volume:
```
cp /root/data/devops.mv.db /usr/src/db
```


## Files Included

- `docker-compose.yml`
- `Dockerfile` (for web service)
- `Dockerfile` (for db service)

## Alternative solution to Docker: Kubernetes

Kubernetes as a Docker Alternative:
Kubernetes emerges as a robust alternative to Docker, offering a comprehensive container orchestration solution. Unlike Docker, which primarily focuses on containerization, Kubernetes extends its capabilities to automate deployment, scaling, and management of containerized applications, especially in large-scale production environments.

While Docker ensures consistency and portability by encapsulating applications within containers, Kubernetes steps in to streamline the management of these containers across clusters of machines. It empowers users to define deployment configurations, services, and networking rules using YAML manifests, thereby providing enhanced flexibility and control over containerized applications.

In essence, while Docker serves as the foundation for containerization, Kubernetes complements it by offering advanced features tailored for orchestrating containerized applications at scale. Together, they form a potent duo for modern software development and deployment, ensuring efficiency and reliability across diverse environments.


## Tagging the Repository

Tag your repository with `ca4-part2`:

```sh
git tag -a ca4-part2 -m "Containers with Docker"
git push origin ca4-part2
```
 
## Conclusion

In this part of the assignment, we have created two Dockerfiles,
one for the H2 database and one for the Spring Boot application. 
We have also created a `docker-compose.yml` file to define the two services 
and build and run the Docker containers using Docker Compose. 
We have also accessed the H2 database console and used the settings to access the database file. 

