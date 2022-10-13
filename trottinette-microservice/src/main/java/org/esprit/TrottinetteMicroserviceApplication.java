package org.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TrottinetteMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrottinetteMicroserviceApplication.class, args);
		System.out.println("Hello");
	}

}
