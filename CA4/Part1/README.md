# To accomplish this assignment, you'll need to follow these steps:

## Prerequisites

- Docker installed on your host machine.
- An account on Docker Hub for publishing the images.

## Steps

### Create a new directory for the assignment:
````
mkdir -p CA4/Part1
cd CA4/Part1
````

### Clone the chat application repository:

First, clone the chat application repository from Bitbucket:
```
git clone https://bitbucket.org/pssmatos/gradle_basic_demo/

```
### Install Docker:
If you don't already have Docker installed on your machine, you'll need to install it.
You can find instructions for your operating system on the Docker website: https://docs.docker.com/get-docker/

## Docker Images

You will create two versions of the Docker image for the chat server:

1. **Version 1:** Build the chat server inside the Dockerfile.
2. **Version 2:** Build the chat server on your host machine and copy the JAR file into the Dockerfile.

## Building and Running the Chat Server

### Version 1: Build Inside Dockerfile
````
# Use a base image with JDK
FROM gradle:jdk17 as builder

# Set the working directory inside the container
WORKDIR /usr/src/devops

# Copy the application source code to the container
ADD ./gradle_basic_demo.zip .

RUN unzip -q ./gradle_basic_demo.zip

# Change the working directory to the copied project directory
WORKDIR ./gradle_basic_demo

# Expose the port that the chat server listens on
EXPOSE 59001

# Build the chat server
RUN chmod +x ./gradlew

RUN gradle clean build

RUN gradle runServer

````
- Run the dockerFile 
- Then  go to the \devops-23-24-PSM-1231849\CA2\Part1\gradle_basic_demo directory
- Run the command .\gradlew runClient
- The chat server should be running and listening on port 59001.
- You can test the chat server by running the chat client on your host machine.
````

### Tag your repository:
Finally, tag your repository with ca4-part1.

````
git tag ca4-part1
git push origin --tags
````
These steps should guide you through packaging and executing the chat server in a Docker container.