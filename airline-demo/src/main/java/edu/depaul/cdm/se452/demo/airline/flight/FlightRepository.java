package edu.depaul.cdm.se452.demo.airline.flight;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByFlightNumber(String flightNum); 
    
    @Override
    List<Flight> findAll();
}