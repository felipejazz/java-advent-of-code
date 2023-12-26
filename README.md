# java-studies

This is the repository of Java studies developed using the Spring Boot framework. Before starting make sure you have the following prerequisites installed on your machine:

## Pré-requisitos

1. **Java:** Make sure you have Java installed. You can download the latest version of Java [here](https://www.oracle.com/java/technologies/javase-downloads.html) or using a version management tool like [SDKMAN!](https://sdkman.io/).
   
  ```bash
   # Verify the Java's version
   java -version
  ```

2. **Maven:** This project uses Maven as a dependency management system. If you don't already have it installed, download and install the latest version of Maven.

   ``` bash 
   # Verify the Maven's version
   mvn -version
   ```
## Compiling and running the project

1. To check if the code is compiling, navigate to the directory where the pom.xml file is located and run the following command:
   ```bash
   # Compiling the project
   mvn compile
   ```

2. To install the code, navigate to the directory where the pom.xml file is located and run the following command:
   ```bash
   # Installing the project
   mvn install
   ```

3. To run the code, navigate to the directory where the pom.xml file is located and execute the following command:
    3.1. If the code does not need to have an input file: 
       ```bash
       # Running the project
       java -jar target/felipe-jazz-0.1.0.jar
       ```
    3.2 If the code does need an input file:
       ```bash
       # Running the project
       java -jar target/felipe-jazz-0.1.0.jar path/to/input/file
       ```
4. To run the tests in the project, navigate tot he directory where the pom.xml file is locates and run the following command:
   ```bash
   # Testing the project
   mvn clean test


5. Example: Running the Day 0 (Hello World).
   ```bash
   cd day_0/src/
   mvn install
   java -jar target/felipe-jazz-0.1.0.jar
   ```
  - The output should be similar to this:
   ```bash
   The current Local Time is 10:57:32.990
   Hello World
   ``` 




    
   

