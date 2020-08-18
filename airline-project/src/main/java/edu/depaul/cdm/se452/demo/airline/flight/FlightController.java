package edu.depaul.cdm.se452.demo.airline.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.depaul.cdm.se452.demo.airline.airport.Airport;
import edu.depaul.cdm.se452.demo.airline.airport.AirportRepository;

@Controller
public class FlightController {
    @Autowired
    private FlightRepository flightRepo;
    
    @Autowired
    private AirportRepository airportRepo;
    
    /**
     * 
     * @param flightRepo
     * @param airportRepo 
    public FlightController(FlightRepository flightRepo, AirportRepository airportRepo) {
        this.flightRepo = flightRepo;
        this.airportRepo = airportRepo;
    }
     */
    
    @GetMapping(path = "/flight", params = "arrivals")
    public String showFromAirport(@RequestParam Long airportId, Model model) {
        Airport airport = airportRepo.findById(airportId).orElseThrow(
                () -> new IllegalArgumentException("Invalid airport id:" + airportId)
        );
        model.addAttribute("flights", airport.getDestinationFlights());
        model.addAttribute("arrivalsOnly", true);
        return "flights/list";
    }

    @GetMapping(path = "/flight", params = "departures")
    public String showToAirport(@RequestParam Long airportId, Model model) {
        Airport airport = airportRepo.findById(airportId).orElseThrow(
                () -> new IllegalArgumentException("Invalid airport id:" + airportId)
        );
        model.addAttribute("flights", airport.getOriginationFlights());
        model.addAttribute("leavingOnly", true);
        return "flights/list";
    }
    
    @GetMapping("/flights")
    public String showAll(Model model) {
        model.addAttribute("flights", flightRepo.findAll());
        
        return "flights/list";
    }

}
