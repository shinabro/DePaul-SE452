package edu.depaul.cdm.se452.demo.airline.flight;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import org.springframework.format.annotation.DateTimeFormat;

import edu.depaul.cdm.se452.demo.airline.airport.Airport;


@Data
@Entity
@Table(name = "flights")
@TypeDefs({
    @TypeDef(name = "hstore", typeClass = PostgreSQLHStoreType.class)
})

public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num")
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "origination_airport", nullable = false)
    @JsonIgnore
    private Airport originationAirport;

    @ManyToOne
    @JoinColumn(name = "destination_airport", nullable = false)    
    @JsonIgnore
    private Airport destinationAirport;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime departureDateTime;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime arrivalDateTime;
    
    @Type(type = "hstore")
    @Column(columnDefinition = "hstore")
    private Map<String, String> attr = new HashMap<String, String>();
}