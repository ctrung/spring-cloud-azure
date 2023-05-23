package com.example.demo;

import com.azure.security.keyvault.secrets.SecretClient;
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

    // Spring Cloud Azure will automatically inject SecretClient in your ApplicationContext.
    private final SecretClient secretClient;

    private final TodoRepository repository;

    private final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public DemoApplication(SecretClient secretClient, TodoRepository repository) {
        this.secretClient = secretClient;
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        String sname = "un-secret-bien-garde";
        log.info("{} : {}", sname, secretClient.getSecret(sname).getValue());

        repository
                .saveAll(Stream.of("A", "B", "C")
                        .map(name->new Todo("configuration", "congratulations, you have set up correctly!", true))
                        .collect(Collectors.toList()))
                .forEach(todo -> log.info("{}", todo));

        System.exit(0);
    }
}

