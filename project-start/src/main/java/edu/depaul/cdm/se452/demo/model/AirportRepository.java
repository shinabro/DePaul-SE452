package edu.depaul.cdm.se452.demo.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Helps to perform CRUD operations for Airport
 */
public interface AirportRepository extends CrudRepository<Airport, Long>  {
    Airport findByCode(String code);
}
