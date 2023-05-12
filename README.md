# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [Azure Key Vault](https://microsoft.github.io/spring-cloud-azure/current/reference/html/index.html#secret-management)

### Guides

The following guides illustrate how to use some features concretely:

* [Read Secrets from Azure Key Vault in a Spring Boot Application](https://aka.ms/spring/msdocs/keyvault)
* [Securing Spring Boot Applications with Azure Key Vault Certificates](https://aka.ms/spring/msdocs/keyvault/certificates)

### Prérequis 

* Avoir un compte / soupscription Azure
* Créer une ressource Azure Keyvault

### Lancement

Sur le poste développeur, testé avec succès avec **Azure CLI v2.48.1**. \
A noter qu'avec **Azure CLI v2.0.81** (version présente au sein du repo Linux Mint), 
les messages d'avertissement sur stderr provoquent des erreurs de parsing JSON.

Comportement connu et corrigé pour azure-identity-js :\
https://github.com/Azure/azure-sdk-for-js/issues/21075 \
(non testé avec une version de azure-identity-java > 1.8.2)

Dans une console shell

`az login`

Puis lancer l'application Spring Boot

`jar -jar ...`

### Additional Links

These additional references should also help you:

* [Azure Key Vault Sample](https://aka.ms/spring/samples/latest/keyvault)

