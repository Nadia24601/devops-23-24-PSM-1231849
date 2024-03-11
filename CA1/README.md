
## Introduction
The provided guide outlines a step-by-step process using version control systems like Git.
This repository contains the code for the Tutorial React.js and Spring Data REST Application, 
as well as additional features and unit tests developed as part of a class assignment. 
The assignment involves adding new fields like Job Years and Email, to record employee data, implementing unit tests, 
and tag the repository at the end of witch task. The assignment goals are documented in this README file.
Also have an Alternative solution using version control systems Mercurial. 

## Creation the repository and the initial commit

##### Create the new repository named devops-23-24-teacher name-student number**


1. **Open the terminal and navigate to the directory where you want to create the new repository.**
    ```
    git clone https://github.com/Nadia24601/devops-23-24-PSM-1231849.git
    ```
2. **Create the README.md and first commit**
    ```
   echo "# devops-23-24-PSM-1231849" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git branch -M main
    git remote add origin https://github.com/Nadia24601/devops-23-24-PSM-1231849.git
    git push -u origin main
    ```
3. **Create the new gitignore.**
    ```
    touch .gitignore
    ```
4. **Open the .gitignore file and add the following lines to it.**
    


## Tutorial React.js and Spring Data REST Application
### Step-by-Step Guide


1. **Clone the repository containing the Tutorial React.js and Spring Data REST Application.**
    ```
    git clone https://github.com/spring-guides/tut-react-and-spring-data-rest
    ```

2. **Create the new folder named CA1 in your repository.**
    ```
    mkdir CA1
    ```

3. **Navigate to CA1 Directory: Change directory to the newly created CA1 folder.**
    ```
    cd CA1
    ```

4. **Copy Tutorial Code: Copy the code of the Tutorial React.js and Spring Data REST Application into the CA1 folder.**
    ```
    cp -r <path_to_tutorial_code>/* .
    ```

5. **Commit Changes: Commit the changes made to the CA1 folder.**
    ```
    git add .
    git commit -m “Update .gitignore and move the tutorial folder to repository "
    ```

6. **Push Changes: Push the committed changes to the master branch.**
    ```
    git push origin master
    ```

7. **Create Initial Tag: Tag the initial version as v1.1.0 and push it to the server.**
    ```
    git tag v1.1.0 -m "tag v1.1.0"
    git push origin v1.1.0
    ```

8. **Develop New Feature:**
    - Add a new field to record the years of the employee in the company.
    - Update the application to support the new field.
    - **Add Unit Tests:** Write unit tests for testing the creation of Employees and the validation of their attributes.
    - **Debugging:** Debug both the server and client parts of the solution to ensure proper functionality.

9. **Commit Changes: Commit the changes made for the new feature and unit tests.**
    ```
    git add .
    git commit -m "Close #(issue number) New field to record the employee's years of service, along with unit tests and attribute validation for the Employee class."
    ```

10. **Push Changes: Push the committed changes to the master branch.**
    ```
    git push origin master
    ```

11. **Create New Tag: Create a new tag for the completed feature and push it to the server.**
    ```
    git tag v1.2.0 -m "tag v1.2.0"
    git push origin v1.2.0
    ```

12. **Mark Repository: At the end of the assignment, mark the repository with the tag ca1-part1.**
    ```
    git tag ca1-part1 -m "tag ca1-part1"
    git push origin ca1-part1
    ```
13. **Create a new branch named email-field**
     ```
       git checkout -b email-field
    ```
14. **Implement support for the email field**
    - Add a new field to record the email of the employee in the company.
    - Update the application to support the new field.
    - **Add Unit Tests:** Write unit tests for testing the creation of Employees and the validation of their attributes.
    ```
15. **Commit Changes: Commit the changes made for the new feature and unit tests.**
    ```
    git status
    git add .
    git commit -m "Close #(issue number) New field to record the employee's email with unit tests."
    git checkout main
    git pull
    git merge --no-ff --no-squash email-field
    git push
    ```
16. **Create New Tag: Create a new tag for the completed feature and push it to the server.**
    ```
    git tag -a v1.3.0 -m "tag v1.3.0"
    git push origin v1.3.0
    ```
17. **Create a new branch named email-field**
    ```
    git checkout -b “fix-invalid-email”
    ```
18. **Fix the invalid email bug**
    - Fix the bug that allows invalid email addresses to be saved in the database.
    - Update the application to support the new field.
    - **Add Unit Tests:** Write unit tests for testing the creation of Employees and the validation of their attributes.
    ```
19. **Commit Changes: Commit the changes made for the new feature and unit tests.**
    ```
    git status
    git add .
    git commit -m "Closes #(issue number). Fixed email bugs and tests”
    git checkout main
    git pull
    git merge --no-ff --no-squash fix-invalid-email
    git push
    ```
20. **Create New Tag: Create a new tag for the completed feature and push it to the server.**
    ```
    git tag -a v1.3.1 -m "tag v1.3.1"
    git push origin v1.3.1
    ```
21. **Mark Repository: At the end of the assignment, mark the repository with the tag ca1-part2.**
    ```
    git tag -a ca1-part2 -m “tag ca1-part2”
    git push --tags
    ```
### Description

This tutorial provides a step-by-step guide for creating a new feature in the Tutorial React.js and Spring Data REST Application.
The new feature involves adding a new field to record the years of service of an employee in the company.
The tutorial also covers the development of unit tests for the new feature, debugging the application, and marking the
repository at the end of the assignment. 
During this work issues were created and closed and the repository was tagged at the end of each task.
A gitignore file was created to ignore the files that are not necessary to be tracked by the version control system.

### Changes Required

**Employee Class:**
- Add the jobYears attribute to store the number of years an employee has been with the company.
- Update the constructor to include the jobYears parameter.
- Update any other relevant methods or validations to accommodate the new attribute.
- Add the email attribute to store the email of the employee.
- Update the constructor to include the email parameter.
- Update any other relevant methods or validations to accommodate the new attribute.

**DatabaseLoader Class:**
- Modify the run method to save employee data with the desired years of service in the database.
- Modify the run method to save employee data with the desired email in the database.
- Ensure that the EmployeeRepository is correctly connected and utilized to save the employee data.

**app.js in the api Package:**
- Add the jobYears attribute to the appropriate location where the other attributes are defined.
- Ensure that the jobYears attribute aligns with the other attributes and is properly handled in the application logic.
- Add the email attribute to the appropriate location where the other attributes are defined.
- Ensure that the email attribute aligns with the other attributes and is properly handled in the application logic.

### Running the Application

To run the application:
1. Ensure that you have Java and Maven installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory.
4. Run `mvn spring-boot:run` to start the Spring Boot application.
5. Access the application at [http://localhost:8080](http://localhost:8080) in your web browser.


## Alternative Solution
For an alternative version control solution, one could consider using Mercurial.


### 1. Comparison of Mercurial and Git:

- **Distributed Version Control:**
    - Both Mercurial and Git are distributed version control systems, allowing users to have a full copy of the repository locally.
    - This enables offline work and faster access to version history.

- **Branching and Merging:**
    - Both Mercurial and Git support branching and merging operations, enabling developers to work on isolated features and merge changes back into the main branch.
    - Mercurial uses a different terminology for some of these operations, such as "update" instead of "checkout" and "commit" instead of "push."
    - Git allows you to create, remove, and modify branches at any moment without impacting previous commits. In Mercurial, we need to make changes in a complete set of a file in a repository.

- **History Tracking:**
    - Both systems track changes to files over time, allowing users to view the history of changes and revert to previous versions if needed.
    - Mercurial uses a different command set for history tracking, such as "hg log" instead of "git log."

- **Collaboration:**
    - Mercurial and Git both support collaboration among multiple developers by allowing them to push and pull changes to and from remote repositories.
    - Mercurial uses a different command set for collaboration, such as "hg push" instead of "git push."

- **Performance:**
    - Git is known for its fast performance, especially when it comes to operations like branching, merging, and committing.
    - Mercurial also offers good performance, but some users have reported that Git is faster in certain scenarios.



## 2. Using Mercurial for the Assignment Goals:

### Repository Setup and Initial Commit:
1. **Create the new repository:**
    - `devops-23-24-teachername-studentnumber`

2. **Clone the repository and initialize:**
    ```
    hg clone https://example.com/Nadia24601/devops-23-24-PSM-1231849
    cd devops-23-24-PSM-1231849
    hg init
    touch README.md
    hg add README.md
    hg commit -m "Initial commit"
    ```

3. **Create .hgignore file and add relevant entries.**


### Tutorial React.js and Spring Data REST Application Integration:
1. **Clone the tutorial repository:**
    ```
    hg clone https://example.com/spring-guides/tut-react-and-spring-data-rest
    ```
2. **Copy the tutorial code into your repository:**
    ```
    cp -r tut-react-and-spring-data-rest/* devops-23-24-PSM-1231849
    ```

3. **Commit changes:**
    ```
    hg add
    hg commit -m "Integrated React.js and Spring Data REST tutorial"
    ```

4. **Create an initial tag:**
    ```
    hg tag v1.1.0
    ``` 

### 1. Add a new field to record years of service and unit tests
1. **Create a new branch from default (master)**
    ```
    hg branch feature/add-years-of-service
    ```
2. **Implement the feature and tests**

 3. **Commit changes**
    ```
    hg commit -m "Added years of service field and tests"
    ```
    
4. **Merge into default (master) and tag**
    ```
    hg update default
    hg merge feature/add-years-of-service
    hg commit -m "Merge feature/add-years-of-service"
    hg tag v1.2.0
    ```
   

### 2. Add email field and fix bugs
1. **Create a new branch**
    ```
    hg branch feature/add-email-field
    ```
2. **Implement the feature and fix bugs**

3. **Commit changes**
    ```
    hg commit -m "Added email field and fixed bugs"
    ```
4. **Merge into default and tag**
    ```
    hg update default
    hg merge feature/add-email-field
    hg commit -m "Merge feature/add-email-field"
    hg tag v1.3.0
    ```
   

### 3. Mark repository at the end of the assignment
    hg tag ca1-part2

## Conclusion:

While Mercurial shares many similarities with Git in terms of version control features and workflow, there are also differences in 
commands and terminology. Overall, both tools are capable of achieving the goals outlined in the assignment, but users may have 
preferences based on their familiarity with the tool's interface and ecosystem.


 
