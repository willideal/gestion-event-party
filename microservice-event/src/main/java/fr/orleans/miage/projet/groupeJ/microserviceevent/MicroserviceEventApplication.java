package fr.orleans.miage.projet.groupeJ.microserviceevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MicroserviceEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEventApplication.class, args);
	}

}
