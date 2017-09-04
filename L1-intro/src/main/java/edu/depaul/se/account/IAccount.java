package edu.depaul.se.account;

/**
 * Sample interface to allow ensure consistent features.
 * Interface answers what should happen not how.
 */
public interface IAccount {

    float getBalance();

    Long getId();

    String getName();

    void setBalance(float balance);

    void setId(Long id);

    void setName(String name);
    
}
