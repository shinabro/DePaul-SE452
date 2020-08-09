package edu.depaul.cdm.se452.demo.airline.passenger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PassengerController {
    @GetMapping("/simple-passenger")
    public String showSingleForm(Passenger passenger) {
        return "passenger/simple-passenger-form";
    }

    @PostMapping("/simple-passenger")
    public String checkSingleForm(@Valid Passenger passenger, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "passenger/simple-passenger-form";
        }

        return "passenger/results";
    }

    @GetMapping("/included-passenger")
    public String showIncludedForm(Passenger passenger) {
        return "passenger/include-passenger-form";
    }

    @PostMapping("/included-passenger")
    public String checkIncludedForm(@Valid Passenger passenger, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "passenger/include-passenger-form";
        }

        return "redirect:/passenger/results";
    }

    
}