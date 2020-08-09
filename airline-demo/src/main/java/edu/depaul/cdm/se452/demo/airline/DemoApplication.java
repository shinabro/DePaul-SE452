package edu.depaul.cdm.se452.demo.airline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.demo.airline.flight.FlightRepository;

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
            repository.findAll().forEach((flight) -> {
                log.info(flight.toString());
            });
            log.info("-------------------------------");
        };
    }

}
