# Spring Boot "Microservice" Trottinette

C'est un exemple d'application Java / Maven / Spring Boot (version 27.5) qui peut être utilisée comme point de départ pour créer un microservice complet .

## Overvie
### The architecture is composed by :

   * [`micro-eureka-server`]: Serveur de découverte Eureka
   * [`micro-api-getway`]: Spring cloud  Gateway vise à fournir un moyen simple mais efficace d'acheminer vers les API et de leur fournir des préoccupations         transversales telles que : la sécurité, la surveillance/les métriques et la résilience. 
   * [`micro-auth-server`]: Service REST simple créé avec `NodeJS', MongoDb` à utiliser comme **service d'authentification**
   * [`micro-trottinette-server`]: Service REST simple créé avec `Spring Boot, Spring Data JPA, MySQL` à utiliser comme un **service de ressources**
   * [`micro-balade-server`]: Service REST simple créé avec `Spring Boot, Spring Data JPA, Postgresql` à utiliser comme un **service de ressources**
   * [`micro-location-server`]: Service REST simple créé avec `Spring Boot, Spring Data JPA, H2` à utiliser comme un **service de ressources**
   * [`micro-association-server`]: Service REST simple créé avec `Spring Boot, Spring Data JPA, MySQL` à utiliser comme un **service de ressources**
   * [`micro-evenement-server`]: Service REST simple créé avec `Spring Boot, Spring Data JPA, MySQL` à utiliser comme un **service de ressources***
   
### Outils dont vous aurez besoin

* Maven 3.0+ est votre outil de construction
* Votre IDE préféré mais nous vous recommanderons `STS-4-4.4.1 version`.
* Serveur MySQL/Postgresql
*JDK 1.8+

### Processus d'exécution du microservice :

- Nous devons d'abord exécuter le "service eureka"
- Deuxièmement, nous devons exécuter `auth-service`
- Troisièmement, nous devons exécuter les autres micros services 
- Enfin, nous devons exécuter `gateway-service`, 

### Eureka Service


![1](https://howtodoinjava.com/wp-content/uploads/2017/07/eureka_console_without_anyClient.jpg)

Eureka Server est une application qui contient les informations sur toutes les applications de service client. Chaque micro service s'enregistrera sur le serveur Eureka et le serveur Eureka connaît toutes les applications client exécutées sur chaque port et adresse IP. Eureka Server est également connu sous le nom de Discovery Server.

Overview

Eureka Service Registry Server – This microservice will provide the service registry and discovery server.
Student Microservice – Which will give some functionality based on Student entity. It will be a rest based service and most importantly it will be a eureka client service, which will talk with eureka service to register itself in the service registry.
School Microservice – Same type as of Student service – only added feature is that it will invoke Student service with service look up mechanism. We will not use absolute URL of student service to interact with that service.
Here is the interaction diagram between above listed three services.


Open SpringEurekaServerApplication class that spring already has generated in the downloaded project and add the @EnableEurekaServerannotation on the class.




@EnableEurekaServer
@SpringBootApplication
public class SpringEurekaServerApplication {
  
    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaServerApplication.class, args);
    }
}
