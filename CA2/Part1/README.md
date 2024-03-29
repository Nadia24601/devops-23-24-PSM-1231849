# Part 1: Build Tools with Gradle

### This CA2 assignment, focusing on practicing Gradle using a simple example application.

## Getting Started
To get started, follow these steps:

1. Create new package CA2 in your repository.

2. Create a new directory Part1 in the CA2 package. This directory will contain all the files related to Part 1 of the assignment

3. Clone this repository to your local machine using the following command:
```
   git clone https://1231849-admin@bitbucket.org/pssmatos/gradle_basic_demo
```
4. Follow the instructions provided in this README to complete the assignment tasks.

## Tasks

### 1. Execute the Server

Add a new task to execute the server.
    
 ```java

task runServer (type:JavaExec, dependsOn: classes){
group = "DevOps"
description = "Launches a chat server on localhost:59001"

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}
```

### 2. Unit Test
Add a simple unit test and update the Gradle script to execute the test.

```java


public class AppTest {
    {
        @Test
        public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting()); }
    }
    

```

### 3. Copy Task
Add a new task of type Copy to make a backup of the sources of the application.
    
  ```java

task backup(type:Copy){
group = "DevOps"
from 'src/main'
into 'backup'
}
 ```
### 4. Zip Task
Add a new task of type Zip to make an archive (zip file) of the sources of the application.
  ```java

task zip(type: Zip) {
group = "DevOps"
description = "Zips the chat server log file."

    from 'src/main'
    archiveFileName = 'src.zip'
    destinationDirectory = file('build')
}
 ```
### 5. Tag
At the end of Part 1, mark your repository with the tag ca2-part1.
    
    git tag ca2-part1
    
### 6. Push
    git push origin ca2-part1
    