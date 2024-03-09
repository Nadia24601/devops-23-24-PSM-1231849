gpus


##Creation the repository and the initial commit

1. **Create the new repository named devops-23-24-teacher name-student number**

2. Open the terminal and navigate to the directory where you want to create the new repository.
    ```
    git clone https://github.com/Nadia24601/devops-23-24-PSM-1231849.git
    ```
   2.1. **Create the README.md and first commit**
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
    git commit -m "Closes #(isseu number). Fixed email bugs and tests”
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
 
