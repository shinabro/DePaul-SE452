package edu.depaul.cdm.se452.demo.airlinedemo.flight;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "reviews")
public class Review implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 4734628184778231571L;
    private String flightNum;
    private String review;
    private String reviewer;
    private Date reviewDate;
}
