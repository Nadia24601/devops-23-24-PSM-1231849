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