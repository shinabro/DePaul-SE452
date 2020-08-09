package edu.depaul.cdm.se452.demo.airlinedemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Value( "${app.greeting}" )
	private String greeting;


	@Test
	public void testGreeting() {
		final String devExpectedGreeting = "Hello Test";
		assertEquals(devExpectedGreeting, greeting);
	}

}
