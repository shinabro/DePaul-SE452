package edu.depaul.cdm.se.sampleproject.relationship.inheritence.oneclassperhierarchy;

import javax.persistence.Entity;

@Entity
public class SalaryEmployee extends Employee {

    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
