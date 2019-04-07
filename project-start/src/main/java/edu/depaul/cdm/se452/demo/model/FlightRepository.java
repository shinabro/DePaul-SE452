package edu.depaul.cdm.se452.demo.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * FlightRepository
 */
public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByFlightNumber(String flightNum); 
}