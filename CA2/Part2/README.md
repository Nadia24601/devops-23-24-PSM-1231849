# Spring Boot Project with React Frontend - Gradle Configuration

This project aims to convert the basic version of the Tutorial application to use Gradle as the build tool instead of Maven.

## Branch Creation and Initial Setup

1. **Create Branch:**

   Create a new branch named `tut-basic-gradle` in your repository and switch to this branch.

    ```
    git checkout -b tut-basic-gradle
    ```

2. **Project Setup:**

    - Navigate to the `CA2` directory in your local repository.
    - Create a directory named `Part2`.
    - Navigate to the `Part2` directory.
    - Generate a new Spring Boot project with  https://start.spring.io using the following configurations:
        - Project: Gradle-Groovy
        - Language: Java
        - Spring Boot: 3.2.4
        - Project Metadata:
            - Group: com.greglturnquist
            - Artifact: react-and-spring-data-rest-basic
            - Name: react-and-spring-data-rest-basic
            - Description: Demo project for Spring Boot
            - Package Name: com.greglturnquist.payroll
        - Packaging: Jar
        - Java: 17
        - Dependencies:
            - Rest Repositories
            - Thymeleaf
            - Spring Data JPA
            - H2 Database
    - Extract the contents of the generated zip file from `https://start.spring.io` into the `CA2/Part2/` folder. This provides the basic structure of a Spring application using Gradle.

## Gradle Configuration

1. **Delete src Folder:**

    ```
    rm -rf src
    ```

   Delete the `src` folder as it will be replaced with code from the basic tutorial.

2. **Copy Code from Basic Tutorial:**

    - Copy the `src` folder and all its subfolders from the basic tutorial into the `CA2/Part2/` folder.
    - Also, copy the `webpack.config.js` and `package.json` files.
   - Change the import in test  class from javax to jakarta.

3. **Update build.gradle:**

   Update the `build.gradle` file with the following configurations:

    ```
    plugins {
        id "org.siouan.frontend-jdk17" version "8.0.0"
    }

    frontend {
        nodeVersion = "16.20.2"
        assembleScript = "run build"
        cleanScript = "run clean"
        checkScript = "run check"
    }
    ```

4. **Update package.json:**

   Update the `package.json` file with the following scripts:

    ```
    "scripts": {
        "webpack": "webpack",
        "build": "npm run webpack",
        "check": "echo Checking frontend",
        "clean": "echo Cleaning frontend",
        "lint": "echo Linting frontend",
        "test": "echo Testing frontend"
    }
    ```

## Building and Running the Application

1. **Execute Gradle Tasks:**

   Execute the following command to build the project:

    ```
    ./gradlew build
    ```

2. **Run the Application:**

   Start the application using the following command:

    ```
    ./gradlew bootRun
    ```

## Additional Gradle Tasks

1. **Copy Generated JAR:**

   Add a task to copy the generated JAR to a folder named `dist` located at the project root level.
 ```
    task copyJar(type: Copy) {
        from 'build/libs'
        into 'dist'
        include '*.jar'
    }
 ```

Ensure this task is executed automatically by Gradle after the `build` task.

1. **Delete Webpack Files:**

   Add a task to delete all files generated by webpack (usually located at `src/main/resources/static/built/`). Ensure this task is executed automatically by Gradle before the `clean` task.
```
task deleteWebpack(type: Delete) {
    delete 'src/main/resources/static/built'
}
```

## Conclusion

After completing the above steps and ensuring all features work as expected, commit your changes and merge them with the `master` branch. Document your work in the `README.md` file, including an analysis of alternatives if conducted.

**Note:** Don't forget to mark your repository with the tag `ca2-part2` at the end of Part 2 of this assignment.