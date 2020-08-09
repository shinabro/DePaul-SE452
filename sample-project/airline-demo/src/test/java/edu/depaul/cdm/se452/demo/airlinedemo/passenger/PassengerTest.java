package edu.depaul.cdm.se452.demo.airlinedemo.passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import edu.depaul.cdm.se452.demo.airline.passenger.Passenger;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class PassengerTest {
    @Test
	public void testShortNameLength() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Passenger passenger = new Passenger();
        passenger.setName("J");
        Set<ConstraintViolation<Passenger>> violations = validator.validate(passenger);

        final int expectedViolation = 1;
		assertEquals(expectedViolation, violations.size());
    }

    @Test
	public void testNoInformation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Passenger passenger = new Passenger();
        Set<ConstraintViolation<Passenger>> violations = validator.validate(passenger);

        final int expectedViolation = 1;
		assertEquals(expectedViolation, violations.size());
    }

    @Test
	public void testMinAge() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Passenger passenger = new Passenger();
        passenger.setName("James");
        passenger.setAge(16);
        Set<ConstraintViolation<Passenger>> violations = validator.validate(passenger);

        final int expectedViolation = 1;
		assertEquals(expectedViolation, violations.size());
    }

    @Test
	public void testValidPassenger() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Passenger passenger = new Passenger();
        passenger.setName("James");
        passenger.setAge(20);
        Set<ConstraintViolation<Passenger>> violations = validator.validate(passenger);

        final int expectedViolation = 0;
		assertEquals(expectedViolation, violations.size());
    }

}