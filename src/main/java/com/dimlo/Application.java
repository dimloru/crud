package com.dimlo;
/*
Just run the app or:
mvn package
java -jar target/javarush-crud-0.1.0-SNAPSHOT.war
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //=
// @EnableAutoConfiguration
// @ComponentScan
// @Configuration
// So no additional Config.java needed
@EnableJpaRepositories("com.dimlo.repositories")
// also beans can be declared here
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // Customize the application or call application.sources(...) to add sources
        // Since our example is itself a @Configuration class (via @SpringBootApplication)
        // we actually don't need to override this method.

//        return builder.sources(Application.class);
        return builder;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}