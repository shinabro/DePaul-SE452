package edu.depaul.cdm.se452.demo.airlinedemo.airport;

import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long>  {
    Airport findByCode(String code);
}
