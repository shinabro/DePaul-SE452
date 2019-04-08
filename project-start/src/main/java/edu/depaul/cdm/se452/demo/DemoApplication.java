package edu.depaul.cdm.se452.demo;

import edu.depaul.cdm.se452.demo.model.Flight;
import edu.depaul.cdm.se452.demo.model.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Bean
	public CommandLineRunner demo(FlightRepository repository) {
		return (args) -> {
			// fetch all customers
			log.info("Flights found with findAll():");
			log.info("-------------------------------");
			for (Flight flight : repository.findAll()) {
				log.info(flight.toString());
			}
			log.info("");
		};
	}	

}
