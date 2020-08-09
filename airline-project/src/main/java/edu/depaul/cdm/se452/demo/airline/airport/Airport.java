package edu.depaul.cdm.se452.demo.airline.airport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import edu.depaul.cdm.se452.demo.airline.flight.Flight;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Data
@Entity
@Table(name = "airports")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class), })
public class Airport implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(max = 5)
    private String code;

    @Column(name = "city_st")
    private String cityState;

    @OneToMany(mappedBy = "originationAirport")
    @ToString.Exclude
    private List<Flight> originationFlights;

    @OneToMany(mappedBy = "destinationAirport")
    @ToString.Exclude
    private List<Flight> destinationFlights;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Review> reviews;

}
