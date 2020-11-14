# Spring Boot example application

## Table of Contents

- [Spring Boot example application](#spring-boot-example-application)
    - [Table of Contents](#table-of-contents)
    - [Development](#development)
        - [Generate a project by Spring Initializr VS Code plugin](#generate-a-project-by-spring-initializr-vs-code-plugin)
        - [Development Cycle](#development-cycle)

## Development

### Generate a project by Spring Initializr VS Code plugin

See [Spring Initializr Java Support](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-spring-initializr) for details.

1. Press `Ctrl + Shift + P` to open command palette.
1. Type `Spring Initializr` to start generating a Maven or Gradle project.
1. Follow the wizard.

### Development Cycle

1. Test.
    ```bash
    $ ./gradlew test
    ```
1. Build an executable JAR.
    ```bash
    $ ./gradlew bootJar
    ```
1. Run.
    ```bash
    $ java -jar ./build/libs/spring-boot-example-*.jar
    # with `dev` profile
    $ java -Dspring.profiles.active=dev -jar ./build/libs/spring-boot-example-*.jar
    ```
1. Access http://localhost:8080/greet
1. Generate JaCoCo reports.
    ```bash
    $ ./gradlew jacocoTestReport
1. Analyze by SonarScanner
    ```bash
    # set access token
    $ cat ~/.gradle/gradle.properties 
    systemProp.sonar.login=<token>
    $ ./gradlew sonarqube
    ```

## References

- [Guides](https://spring.io/guides)
    - [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
    - [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
