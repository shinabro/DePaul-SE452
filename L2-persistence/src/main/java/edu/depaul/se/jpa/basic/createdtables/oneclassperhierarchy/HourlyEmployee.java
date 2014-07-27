package edu.depaul.se.jpa.basic.createdtables.oneclassperhierarchy;

import javax.persistence.Entity;

@Entity
public class HourlyEmployee extends Employee {
    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
