package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Matériel de référence :
 *
 * Spring + Azure Key Vault :
 * https://learn.microsoft.com/fr-fr/azure/developer/java/spring-framework/configure-spring-boot-starter-java-app-with-azure-key-vault
 *
 * Spring + Azure MySQL :
 * https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-mysql
 */
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final TodoRepository repository;

    private final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public DemoApplication(TodoRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // Remplissage de la BDD
        repository
                .saveAll(Stream.of("A", "B", "C")
                        .map(name->new Todo("configuration " + name, "congratulations, you have set up correctly!", true))
                        .collect(Collectors.toList()))
                .forEach(todo -> log.info("Created {}", todo));
    }
}

