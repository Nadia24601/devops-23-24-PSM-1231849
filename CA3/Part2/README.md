# Setting up Vagrant for Spring Boot Application with Gradle

This guide will help you set up a Vagrant virtual environment to execute a Spring Boot application using Gradle. The environment consists of two virtual machines:

1. **web**: This VM runs Tomcat and the Spring Boot application.
2. **db**: This VM executes the H2 server database.

1. ## Create CA3/Part2 directory
````
mkdir -p CA3/Part2
cd CA3/Part2
````

1. ## Clone Repository

```
git clone https://bitbucket.org/pssmatos/vagrant-multi-spring-tut-demo.git
```

2. ## Read the README.md file in the repository

The repository contains a README.md file with instructions.

3. ## Change properties in application.properties

```
Go to CA2/Part2/react-and-spring-data-rest-basic/src/main/resources/application.properties and change the following properties:
server.servlet.context-path=/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT
spring.data.rest.base-path=/api

spring.datasource.url=jdbc:h2:tcp://192.168.56.11:9092/./jpadb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true

```

4. ## Go to Vaagrantfile

The Vagrantfile contains the configuration for the two virtual machines.
Change the configuration according to your needs.

```
  openjdk-17-jdk-headless
  
 # Change the following command to clone your own repository!
          git clone https://github.com/Nadia24601/devops-23-24-PSM-1231849.git
          cd devops-23-24-PSM-1231849/CA2/Part2/react-and-spring-data-rest-basic
          chmod u+x gradlew
          ./gradlew clean build
          ./gradlew bootRun
           nohup ./gradlew bootRun > /home/vagrant/spring-boot-app.log 2>&1 &
          # To deploy the war file to tomcat9 do the following command:
           sudo cp ./build/libs/basic-0.0.1-SNAPSHOT.war /var/lib/tomcat9/webapps
        SHELL
  end
end
```

5. ## Start the VMs

```
varant destroy -f
vagrant up
```

6. ## Access the Spring Boot application
```
http://localhost:8080/
```
7. ## Access the H2 database
```
http://localhost:8082/
```
For the connection string use: jdbc:h2:tcp://192.168.56.11:9092/./jpadb


### Analysis of the alternative Solution - VMware

VirtualBox, is open-source and free, making it ideal for personal use and smaller-scale virtualization.
It's user-friendly with a simple interface, suitable for running virtual machines on desktops.
In contrast, VMware, from VMware Inc., offers both free (like VMware Workstation Player) and commercial
(VMware Workstation Pro, VMware vSphere) versions.

VMware is known for its polished interface, advanced features (like snapshotting and live migration), and robustness,
making it preferred for professional and enterprise environments requiring scalability and extensive functionality.
VMware's ecosystem includes solutions for server virtualization (vSphere) and cloud-based virtualization,
whereas VirtualBox excels in desktop integration and development/testing scenarios.
Ultimately, the choice between them depends on specific needs, preferences, and the scale of virtualization deployment.

### Implementation of the alternative Solution - VMware

1. Make download and install VMware Workstation Player on your computer

2. Create a Vangrad file with the following configuration:
   bash
   Vagrant.configure("2") do |config|


# Specify the VMware provider


      config.vm.provider "vmware_desktop" do |v|
      v.vmx["memsize"] = "1024"  # Memory settings for the VM
      end

      config.vm.define "db" do |db|
      db.vm.box = "ubuntu/bionic64"
      db.vm.hostname = "db"
      db.vm.network "private_network", ip: "192.168.56.11"

    db.vm.provider "vmware_desktop" do |v|
      v.vmx["memsize"] = "1024"  # Memory settings for the VM
    end

    db.vm.network "forwarded_port", guest: 8082, host: 8082
    db.vm.network "forwarded_port", guest: 9092, host: 9092

    db.vm.provision "shell", inline: <<-SHELL
      sudo apt-get update -y
      sudo apt-get install -y iputils-ping avahi-daemon libnss-mdns unzip openjdk-17-jdk-headless

      wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar

      java -cp ./h2*.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -ifNotExists > ~/out.txt &
    SHELL
      end

         config.vm.define "web" do |web|
      web.vm.box = "ubuntu/bionic64"
      web.vm.hostname = "web"
      web.vm.network "private_network", ip: "192.168.56.10"

    web.vm.provider "vmware_desktop" do |v|
      v.vmx["memsize"] = "2048"  # Memory settings for the VM (increased for web server)
    end

    web.vm.network "forwarded_port", guest: 8080, host: 8080

    web.vm.provision "shell", inline: <<-SHELL, privileged: false
      sudo apt-get update -y
      sudo apt-get install -y git nodejs npm
      sudo ln -s /usr/bin/nodejs /usr/bin/node
      sudo apt install -y tomcat9 tomcat9-admin

     git clone https://github.com/Nadia24601/devops-23-24-PSM-1231849.git
          cd devops-23-24-PSM-1231849/CA2/Part2/react-and-spring-data-rest-basic
      chmod u+x gradlew
      ./gradlew clean build
      nohup ./gradlew bootRun > /home/vagrant/spring-boot-app.log 2>&1 &

      sudo cp ./build/libs/basic-0.0.1-SNAPSHOT.war /var/lib/tomcat9/webapps
   
    SHELL
      end
    end


