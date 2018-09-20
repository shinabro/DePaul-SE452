package edu.depaul.cdm.se.sampleproject.relationship.inheritence.onetableperclass;

import javax.persistence.Entity;

@Entity
public class T_HourlyEmployee extends T_Employee {

    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
