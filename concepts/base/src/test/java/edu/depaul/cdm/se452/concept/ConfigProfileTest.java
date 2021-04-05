package edu.depaul.cdm.se452.concept;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class ConfigProfileTest {
    @Value("${app.greeting}")
    private String greeting;    
    
    @Test
    void testGreeting() {
        assertThat("SE 452 Dev").isEqualTo(greeting);
    }    
        
}
