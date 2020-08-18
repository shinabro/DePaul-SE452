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
    @Value( "${spring.profiles.active}" )
    private String env;

    @Bean
    public CommandLineRunner showMessage() {
      return (args) -> {
        System.out.println(env);
      };
    }    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


}