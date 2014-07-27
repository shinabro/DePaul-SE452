package edu.depaul.se.account;

public interface IAccount {

    float getBalance();

    Long getId();

    String getName();

    void setBalance(float balance);

    void setId(Long id);

    void setName(String name);
    
}
