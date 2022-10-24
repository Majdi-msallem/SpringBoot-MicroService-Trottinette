
![1](https://howtodoinjava.com/wp-content/uploads/2017/07/eureka_console_without_anyClient.jpg)

Spring Cloud Service Discovery with Netflix Eureka

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
