package fr.orleans.miage.projet.groupeJ.microserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication

@EnableFeignClients("fr.orleans.miage.projet.groupeJ.microserviceclient")
@EnableConfigurationProperties
@EnableDiscoveryClient
public class MicroserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientApplication.class, args);


	}

}
