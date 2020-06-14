package edu.depaul.cdm.se452.demo.airlinedemo.passenger;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Passenger {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    
    @Min(18)
    private Integer age;
}
