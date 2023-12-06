package org.ENSAJ.ClientService;

import org.ENSAJ.ClientService.Model.Client;
import org.ENSAJ.ClientService.Repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner initialiserBaseH2(ClientRepository clientRepository){
		return args -> {
			clientRepository.save(new Client(Long.parseLong("1"), "ELBAHJA Charafeddine", Float.parseFloat("23")));
			clientRepository.save(new Client(Long.parseLong("2"), "ELBAHJA Abdelhakim", Float.parseFloat("26")));
			clientRepository.save(new Client(Long.parseLong("3"), "Rachid Amine", Float.parseFloat("23")));
		};
	}

}
