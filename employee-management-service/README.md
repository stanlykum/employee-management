# employee-management-service

## Purpose

This SpringBoot application covers the implementation of the employee management service

## Technologies

| Name       | Used              |
|------------|-------------------|
| Build Tool | Gradle            |
| Language   | Java 17          |
| Framework  | Spring boot       |
| Testing    | Junit,Mockito,Spring Test  |

## Contents

Outline the file contents of the repository. It helps users navigate the codebase, build configuration and any related
assets.

| File/folder       | Description                                |
|-------------------|--------------------------------------------|
| `src`             | Source code.                        |
| `.gitignore`      | Define what to ignore at commit time.      |
| `.dockerignore`   | Define what to ignore at from build context.      |
| `build.gradle`    | The gradle configuration to this project.  |
| `README.md`       | This README file.                          |

### Prerequisites

To run the project you will need to have the following installed:

* Java 17

For information about the software versions used to build this API and a complete list of it's dependencies see
build.gradle

## Building the application

The project uses [Gradle](https://gradle.org) as a build tool. It already contains
`./gradlew` wrapper script, so there's no need to install gradle.

To build the project execute the following command:

```bash
  ./mvn clean install
```

**or**

```bash
  mvn clean install
```

To clean up your environment use the following, it will delete any temporarily generated files such as reports.

```bash
  ./mvn clean clean
```

**or**

```bash
  mvn clean
```

### Running

Alternatively, you can start the application from the current source files using Gradle as follows:

 ```
 ./mvn spring-boot:run
 ```

**or**

  ```
 mvn spring-boot:run
 ```

### Testcase Running

Testsuites can be run with below command.

 ```
 ./mvn clean test
 ```

**or**

 ```
 mvn clean test
 ```

## Swagger UI

You can access the Swagger UI for this application at the following URL:

[Swagger UI](http://localhost:8801/swagger-ui/index.html)

## Docker

Latest Docker build available at stanlyajeesh/employee-management-service:latest

Docker Build

```
docker build -t stanlyajeesh/employee-management-service:latest .
```

Docker Run

```
docker run -p 8801:8801 stanlyajeesh/employee-management-service
```

Docker Push

```
docker login

docker push stanlyajeesh/employee-management-service:latest
```

Docker Pull

```
docker pull stanlyajeesh/employee-management-service:latest
```

