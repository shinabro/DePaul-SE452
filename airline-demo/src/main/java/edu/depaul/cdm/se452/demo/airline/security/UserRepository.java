package edu.depaul.cdm.se452.demo.airline.security;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserByUsername(String username);
}
