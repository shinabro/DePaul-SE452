package edu.depaul.cdm.se.sampleproject.relationship.inheritence.onetableperconcrete;

import javax.persistence.Entity;

@Entity
public class C_HourlyEmployee extends C_Employee {

    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
