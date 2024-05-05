# Virtual Machine Setup and Project Execution Guide

This guide explains the process of setting up and executing projects inside VirtualBox with Ubuntu.

## 1. Creating the Virtual Machine
Should start by creating your VM as described in the lecture.

## 2. Cloning Repository

Clone your individual repository inside the VM:

```
git clone https://github.com/Nadia24601/devops-23-24-PSM-1231849.git
```

Install git and openjdk-11-jdk:

```
sudo apt update
sudo apt install git
sudo apt install openjdk-11-jdk
```

# 3. Building and Executing Projects

## Maven Project

### 1. Install Maven:

```
sudo apt install maven
```

### 2. Navigate to the Maven project directory:

```
cd ./devops-23-24-PSM-1231849/CA1/tut-react-and-spring-data-rest/basic

```

### 3. Build and run the project:

```
mvn spring-boot:run

```

### 4. Accessing Web Applications:

For web projects, access the applications from the browser in your host machine. Use the following format:
Replace `192.168.56.5` with the IP address of your VM.

```
http://192.168.56.5:8080

```


## Gradle Project (gradle_basic_demo)

### 1. Install Gradle:

```
sudo apt install gradle

```

Make sure you have the premissons to run the gradlew file:
```
chmod +x gradlew
```
### 2. Navigate to the Gradle project directory:
```
cd /devops-23-24-PSM-1231849/CA2/Part1/gradle_basic_demo
```

### 3. Build the project:
```
gradlew build
   ```
### 4. Run the project:
   ```
java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp <server port> (59001)
   ```
### 5. Run a client:
```
./gradlew runClient
```
### 6. Note:
-Make sure to replace `/path/to/maven/project` and `/path/to/gradle/project` with the actual paths to your Maven and Gradle projects respectively.

-The above task assumes the chat server's IP is "localhost" and its port is "59001". Edit the runClient task in the "build.gradle" file in the project's root directory with the right IP

-Running the server inside the VM and the clients in your host machine allows you to interact with the server running inside the VM over the network. This simulates real-world scenarios where clients connect to a remote server.


