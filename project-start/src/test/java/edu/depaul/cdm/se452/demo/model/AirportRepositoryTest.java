package edu.depaul.cdm.se452.demo.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AirportRepositoryTest {
    @Autowired
    private AirportRepository repository;

    @Test
    public void findByAiportCode() {
        final String ORD = "ORD";
        final String CHICAGO = "Chicago, IL";
        Airport ord = repository.findByCode(ORD);
        assertEquals(CHICAGO, ord.getCityState());
        assertEquals(3, ord.getOriginationFlights().size());
    }
}
