package com.dimlo.controller;
/*
https://spring.io/guides/gs/serving-web-content/

Build an executable JAR
You can run the application from the command line with Gradle or Maven.
Or you can build a single executable JAR file that contains all the necessary
dependencies, classes, and resources, and run that. This makes it easy to ship,
version, and deploy the service as an application throughout the development
lifecycle, across different environments, and so forth.

If you are using Gradle, you can run the application using
./gradlew bootRun
. Or you can build the JAR file using
./gradlew build
. Then you can run the JAR file:
java -jar build/libs/gs-serving-web-content-0.1.0.jar


If you are using Maven, you can run the application using:
./mvnw spring-boot:run
. Or you can build the JAR file with^
./mvnw clean package
OR
mvn package
. Then you can run the JAR file:

java -jar target/gs-serving-web-content-0.1.0.jar
*/



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}