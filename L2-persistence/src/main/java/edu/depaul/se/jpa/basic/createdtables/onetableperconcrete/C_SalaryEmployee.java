package edu.depaul.se.jpa.basic.createdtables.onetableperconcrete;

import javax.persistence.Entity;

@Entity
public class C_SalaryEmployee extends C_Employee{
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
