## Documentation de référence

* [Authentification Azure Spring Cloud](https://learn.microsoft.com/fr-fr/azure/developer/java/spring-framework/authentication)
* [Azure Identity client library for Java](https://learn.microsoft.com/fr-fr/java/api/overview/azure/identity-readme?view=azure-java-stable)

* [Azure Key Vault](https://microsoft.github.io/spring-cloud-azure/current/reference/html/index.html#secret-management)
* [Charger un secret à partir d’Azure Key Vault dans une application Spring Boot](https://learn.microsoft.com/fr-fr/azure/developer/java/spring-framework/configure-spring-boot-starter-java-app-with-azure-key-vault)

* [Azure Database for MySQL - Flexible Server](https://learn.microsoft.com/en-us/azure/mysql/flexible-server/overview)
* [Use Spring Data JPA with Azure Database for MySQL](https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-mysql)

## Prérequis

* Un service Azure Keyvault 
* Un service Azure MySQL Flexible server (Single server déprécié)

En plus, pour une exécution sur le poste local :
* Azure CLI (v2.48.1 testé avec succès) + compte Azure \
ou 
* Un service principle 

En plus, pour un déploiement sur Azure : 
* Une identité managée

## Exécution poste local

### Avec Azure CLI
```
az login # suivre les indications s'affichant dans le navigateur web

export AZURE_KEY_VAULT_NAME=...
export AZURE_MYSQL_NAME=...
export AZURE_DB_NAME=...

mvn spring-boot:run
```

### Avec un service principle
```
export AZURE_CLIENT_SECRET=...
export AZURE_CLIENT_ID=...
export AZURE_TENANT_ID=...

export AZURE_KEY_VAULT_NAME=...
export AZURE_MYSQL_NAME=...
export AZURE_DB_NAME=...

mvn spring-boot:run
```