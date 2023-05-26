package com.example.demo;

import com.azure.security.keyvault.secrets.SecretClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    private final Logger log = LoggerFactory.getLogger(DemoController.class);

    // Spring Cloud Azure will automatically inject SecretClient in your ApplicationContext.
    private final SecretClient secretClient;

    private final TodoRepository repository;

    public DemoController(SecretClient secretClient, TodoRepository repository) {
        this.secretClient = secretClient;
        this.repository = repository;
    }

    @GetMapping(value = "/")
    public Map<String, Object> getTestData() {

        Map<String, Object> result = new HashMap<>();

        // Azure Key Vault
        String sname = "un-secret-bien-garde";
        String secret = secretClient.getSecret(sname).getValue();
        log.info("{} : {}", sname, secret);
        result.put(sname, secret);

        // Azure MySQL
        result.put("todos", repository.findAll());

        return result;
    }
}