package edu.depaul.cdm.se452.demo.airlinedemo.airport;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -7241408726301245349L;
    private String author;
    private String review;
}
