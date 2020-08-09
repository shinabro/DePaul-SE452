package edu.depaul.cdm.se452.concept;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Sample to demonstrate profile (application-dev vs application-prod)
 */
@SpringBootApplication
public class Main {
    @Value( "${app.greeting}" )
    private String greeting;
  
    @Bean
    public CommandLineRunner showMessage() {
      return (args) -> {
        System.out.println("begin encoded");
        System.out.println(greeting);
              System.out.println("end encoded");
      };
    }    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}