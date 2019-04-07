package edu.depaul.cdm.se452.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "flights")
@Data
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num")
    private String flightNumber;
    
    @OneToOne
    @JoinColumn(name = "origination_airport", nullable = false)    
    private Airport originationAirport;

    private Timestamp departureDateTime;

    private Timestamp arrivalDateTime;
}
