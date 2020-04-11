package edu.depaul.cdm.se452.demo;

import edu.depaul.cdm.se452.demo.model.Airport;
import edu.depaul.cdm.se452.demo.model.AirportRepository;
import edu.depaul.cdm.se452.demo.model.Flight;
import edu.depaul.cdm.se452.demo.model.FlightRepository;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
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

    /**
     * Demo of listing data
     * @param repository
     * @return 
     */
    @Bean
    public CommandLineRunner demo(FlightRepository flightRepository, AirportRepository airportRepository) {
        return (args) -> {
            Airport originationAirport = airportRepository.findByCode("ORD");
            Airport destinationAirport = airportRepository.findByCode("DEN");
            
            Flight flight2 = new Flight();
            flight2.setFlightNumber("SW1234");
            Calendar cal = new GregorianCalendar();
            flight2.setArrivalDateTime(new Timestamp(cal.getTimeInMillis()));
            flight2.setOriginationAirport(originationAirport);
            flight2.setDestinationAirport(destinationAirport);
            flightRepository.save(flight2);
        };
    }
    
    /**
     * Demo of listing data
     * @param repository
     * @return 
     */
    @Bean
    public CommandLineRunner showAllFlights(FlightRepository repository) {
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
