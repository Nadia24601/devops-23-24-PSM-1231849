### Step-by-Step Guide for CA5: CI/CD Pipelines with Jenkins

#### 1. *Set Up Your Jenkins Environment*

*Install Jenkins:*
- Follow [Jenkins Homebrew Install Instructions](https://www.jenkins.io/doc/book/installing/windows/).

- *Using Docker:*
 ````
  docker run -d -p 8080:8080 -p 50000:50000 -v jenkins-data:/var/jenkins_home --name=jenkins jenkins/jenkins:lts-jdk17
````

Access Jenkins at http://localhost:8080 and complete the setup steps.

- *Using Docker:*
  Access Jenkins at http://localhost:8080 and complete the setup steps.
*Install the necessary plugins:*
- Go to the Jenkins dashboard and click on "Manage Jenkins".
- Click on "Manage Plugins" and install the following plugins:
  - Docker Pipeline
  - HTML Publisher
  - Docker API Plugin

#### 2. *Create a Jenkins Job for the Pipeline Ca2 Part1 *


*Create a Jenkins  job*
- Go to the Jenkins dashboard, click on "New Item".
- Enter the job name, select "Pipeline", and click "OK".
```
pipeline {
agent any
stages {
stage('Checkout') {
steps {
echo 'Checking out repo...'
git branch: 'main', url:  'https://github.com/Nadia24601/devops-23-24-PSM-1231849.git'
}
}
stage('Assemble') {
steps {
echo 'Assembling project...'
dir('CA2/Part1/gradle_basic_demo') {

sh 'chmod +x gradlew'
sh './gradlew assemble'
}
}
}

 stage('Test') {
  steps {
  echo 'Testing project...'
  dir('CA2/Part1/gradle_basic_demo') {
  sh './gradlew test'
          }
        }
      }
 stage('Archive') {
 steps {
 dir('CA2/Part1/gradle_basic_demo') {
 archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
          }
        }
      }
}
}
```
- Click on "Save".
- Click on "Build Now" to execute the pipeline.
- Check the console output for the pipeline stages and verify the build status is successful.


#### 3. *Create a Jenkins Script for the Pipeline Ca2 Part1 Jenkins file*

-Create a Jenkins file with the pipeline script created in the previous step on CA5 in repository.
- Copy the script in previous step and save it as Jenkinsfile_CAP1 in the repository.
- Commit and push the changes to the repository.

*Create a new Jenkins job for the pipeline using the Jenkinsfile_CAP1 script:*
- Go to the Jenkins dashboard, click on "New Item".
- Enter the job name, select "Pipeline", and click "OK".

*Configure the pipeline:*
- Select GitHub project and enter the URL of the gradle_basic_demo repository.
- In the "Pipeline" section, select "Pipeline script from SCM".
- In SCM, set it to "Git" and enter the repository URL.
- In Branches to build, enter "main".
- In Script Path, enter the path to the Jenkins file.
- Click "Save".

*Run the pipeline:*
- Click on "Build Now" to execute the pipeline.
- Check the console output for the pipeline stages and verify the build status is successful.


#### 3. *Create a Jenkins Script for the Pipeline Ca2 Part2*

*Follow the steps on the link to install to do correctly this part of the assignment:*

````
https://www.jenkins.io/doc/book/installing/docker/
````

- To creat a bridge network in Docker run the following command:

````
docker network create jenkins
````
- To download and Run a docker:dind Docker image with the following command:

````
docker run --name jenkins-docker --rm --detach --privileged --network jenkins --network-alias docker 
--env DOCKER_TLS_CERTDIR=/certs --volume jenkins-docker-certs:/certs/client --volume jenkins-data:/var/jenkins_home
--publish 2376:2376 docker:dind

````
- Create a Dockerfile with the following content:
FROM jenkins/jenkins:2.452.2-jdk17
USER root
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
https://download.docker.com/linux/debian \
$(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean docker-workflow"

-uild a new docker image from this Dockerfile and assign the image a meaningful name using the following command:

````
docker build -t myjenkins-blueocean:2.452.2-1 .
````
- Run your own myjenkins-blueocean:2.452.2-1 image as a container in Docker using the following docker run command:

````
docker run --name jenkins-blueocean --restart=on-failure --detach --network jenkins --env DOCKER_HOST=tcp://docker:2376 
 --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 --volume jenkins-data:/var/jenkins_home ^
 --volume jenkins-docker-certs:/certs/client:ro --publish 8080:8080 --publish 50000:50000 myjenkins-blueocean:2.452.2-1
 
````

*Create a new Jenkins file with the pipeline script for the Part2 of the assignment:*

```
pipeline {
    agent any
 environment {
        DIR = 'CA2/Part2/react-and-spring-data-rest-basic'
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out repo...'
                git branch: 'main', url: 'https://github.com/Nadia24601/devops-23-24-PSM-1231849.git'
            }
        }

        stage('Assemble') {
            steps {
                echo 'Assembling project...'
                dir('CA2/Part2/react-and-spring-data-rest-basic') {
                    sh 'chmod +x gradlew'
                    sh './gradlew assemble'
                }
            }
        }

        stage('Test') {
                    steps {
                        echo 'Testing project...'
                        dir('CA2/Part2/react-and-spring-data-rest-basic') {
                            sh './gradlew test'
                        }
                    }
                }

        stage('Javadoc') {
            steps {
             echo 'Generating Javadocs...'
                dir('CA2/Part2/react-and-spring-data-rest-basic') {
                    sh './gradlew javadoc'
                }
                    publishHTML(target: [
                        allowMissing         : false,
                        alwaysLinkToLastBuild: true,
                        keepAll              : true,
                        reportDir            : 'CA2/Part2/react-and-spring-data-rest-basic/build/docs/javadoc',
                        reportFiles          : 'index.html',
                        reportName           : 'Javadoc'
                    ])
                }
           }

        stage('Archive') {
            steps {
                echo 'Archiving artifacts...'
                dir('CA2/Part2/react-and-spring-data-rest-basic') {
                    archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }

        stage('Create Dockerfile') {
                    steps {
                        echo 'Creating Dockerfile...'
                        dir('CA2/Part2/react-and-spring-data-rest-basic') {
                            script {
                                def dockerfileContent = """
                                FROM gradle:jdk17
                                WORKDIR /app
                                COPY build/libs/*.jar app.jar
                                EXPOSE 8080
                                ENTRYPOINT ["java", "-jar", "app.jar"]
                                """
                                writeFile file: 'DockerfileCA2P2', text: dockerfileContent
                            }
                        }
                    }
                }
                   stage('Publish Docker Image') {
                            steps {
                                echo 'Publishing Docker image...'
                                dir('CA2/Part2/react-and-spring-data-rest-basic') {
                                    script {
                                        def dockerImage = docker.build("nadia24601/devops:${env.BUILD_ID}", "-f DockerfileCA2P2 .")
                                        docker.withRegistry('https://index.docker.io/v1/', 'dockerhub_id') {
                                        dockerImage.push()
                                        }
                                    }
                                }
                             }
                          }
                        }
                      }


````

- Save the Jenkins file as Jenkinsfile_CAP2 in the repository.
- Commit and push the changes to the repository.


*Create a new Jenkins job for the pipeline using the Jenkinsfile_CAP2 script:*
- Go to the Jenkins dashboard, click on "New Item".
- Enter the job name, select "Pipeline", and click "OK".
- Select GitHub project and enter the URL of the gradle_basic_demo repository.
- In the "Pipeline" section, select "Pipeline script from SCM".
- In SCM, set it to "Git" and enter the repository URL.
- In Branches to build, enter "main".
- In Script Path, enter the path to the Jenkinsfile.
- Click "Save".


*Run the pipeline:*
- Click on "Open Blue Ocean" and Build on the pipeline.
- Check the console output for the pipeline stages and verify the build status.
- If the pipeline runs successfully, the Docker image will be published to Docker Hub.



#### 4.*Use a Docker compose to automate the creation of the two services and network:*

- Create a Docker compose file with the following content:

````
services:
  docker-dind:
    container_name: jenkins-docker
    image: docker:dind
    privileged: true
    environment:
      - DOCKER_TLS_CERTDIR=/certs
    volumes:
      - jenkins-docker-certs:/certs/client
      - jenkins-data:/var/jenkins_home
    networks:
      jenkins:
        aliases:
          - docker
    ports:
      - 2376:2376

  jenkins-blueocean:
    build: .
    container_name: jenkins-blueocean
    restart: on-failure
    environment:
      - DOCKER_HOST=tcp://docker:2376
      - DOCKER_CERT_PATH=/certs/client
      - DOCKER_TLS_VERIFY=1
    volumes:
      - jenkins-data:/var/jenkins_home
      - jenkins-docker-certs:/certs/client:ro
    networks:
      - jenkins
    ports:
      - 8080:8080
      - 50000:50000

volumes:
  jenkins-docker-certs:
  jenkins-data:

networks:
  jenkins:
  
   ```` 
- Run the following command to start the services using the Docker compose file:

````
docker-compose up
````
#### 5. *Tag Your Repository*

*Add a tag:*
- Once your pipeline is successfully running, tag your repository with ca5.

````
git tag ca5
git push origin ca5
````
#### 6. *Conclusion*

Doing the CA5 assignment on CI/CD pipelines using Jenkins, Docker, and Docker Compose showed our ability to set 
up advanced environments for improving software development efficiency. Jenkins helped automate the entire software 
delivery process. Docker played a crucial role in ensuring consistent environment setup and smooth container builds
across different pipeline stages. Using Docker Compose enhanced our infrastructure by managing multiple services, 
including Jenkins and Docker containers for building environments, ensuring scalability and efficiency in handling 
our CI/CD workflows. This project deepened our understanding of CI/CD principles and equipped us with practical skills
in configuring and optimizing development environments for faster and more reliable software releases.



