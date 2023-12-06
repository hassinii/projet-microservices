package org.ensaj;
import org.ensaj.Model.Voiture;
import org.ensaj.Repository.VoitureRepository;
import org.ensaj.clients.ClientRest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class VoitureApplication {
	private VoitureRepository voitureRepository;
	private ClientRest clientRest;

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}


	@Bean
	CommandLineRunner initialiserDataBase(VoitureRepository voitureRepository,ClientRest clientRest){
		return args -> {
			clientRest.allClient().forEach(c ->{
				String matricule = genererChaineAleatoire();
				String marque = genererChaineAleatoire();
				String model = genererChaineAleatoire();
				voitureRepository.save(new Voiture(matricule, marque, model,c.getId()));
			});

		};
	}

	public static String genererChaineAleatoire() {
		String caracteresPermis = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			int indexAleatoire = random.nextInt(caracteresPermis.length());
			char caractereAleatoire = caracteresPermis.charAt(indexAleatoire);
			sb.append(caractereAleatoire);
		}

		return sb.toString();
	}


}
