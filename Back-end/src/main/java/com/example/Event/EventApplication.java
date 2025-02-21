package com.example.Event;

import com.example.Event.enums.Status;
import com.example.Event.models.Client;
import com.example.Event.models.Evenment;
import com.example.Event.repositories.ClientRepository;
import com.example.Event.repositories.EvenementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(
			ClientRepository repository , EvenementRepository evenementRepository
	) {
		return args -> {
			Client client = new Client(
					"alae@gmail.com",
					"password",
					null, // ProfileImage
					null, // invitations
					null, // tickets
					null, // evenments
					"adresse",
					LocalDate.of(1990, 5, 15),
					"alae@gmail.com",
					"El Andaloussi",
					"Alae eddine",
					7646446
			);
			repository.save(client);
			Evenment evenment = new Evenment();
			evenment.setImage(null);
			evenment.setLocalisation("Tangier");
			evenment.setPrice(200);
			evenment.setStatus(Status.CLOSED);
			evenment.setEventDate(LocalDate.now());
			evenementRepository.save(evenment);
		};
	}




}
