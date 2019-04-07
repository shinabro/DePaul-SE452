package edu.depaul.cdm.se452.demo.model;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightRespositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FlightRepository repository;

    @Test
    public void testFindAll() {
        int numOfRows = 0;
        final int EXPECTED_NUM_OF_ROWS = 3;
        for (Flight flight : repository.findAll()) {
            numOfRows++;
        }
        Assert.assertEquals(numOfRows, EXPECTED_NUM_OF_ROWS);
    }

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        final String FLIGHT_NUM = "SW998";
        Flight swFlight = new Flight();
        swFlight.setFlightNumber(FLIGHT_NUM);
        entityManager.persist(swFlight);
        entityManager.flush();

        // when
        Flight found = repository.findByFlightNumber(FLIGHT_NUM).get(0);

        // then
        Assertions.assertThat(found.getFlightNumber())
                .isEqualTo(swFlight.getFlightNumber());
    }

}
