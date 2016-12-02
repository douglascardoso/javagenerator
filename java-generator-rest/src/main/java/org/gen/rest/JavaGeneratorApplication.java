package org.gen.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.gen"})
public class JavaGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGeneratorApplication.class, args);

    }
}
