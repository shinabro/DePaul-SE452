package edu.depaul.cdm.se452.demo.airline.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportRepository repo;

    /**
     * Example showing auto binding by the framework to setup repo
    public AirportController(AirportRepository repo) {
        this.repo = repo;
    }
     */
    

    @GetMapping
    public String showAll(Model model) {
        Iterable<Airport> airports = repo.findAll();
        model.addAttribute("airports", airports);

        return "airports/list";
    }

    @GetMapping(params = "add")
    public String add(Model model) {
        model.addAttribute("airport", new Airport());
        return "airports/form";
    }

    /**
     * Demo showing handling of request param
     *
     * @param code
     * @param model
     * @return
     */
    @GetMapping(params = "edit")
    public String edit(@RequestParam String code, Model model) {
        Airport airport = repo.findByCode(code);
        model.addAttribute(airport);
        return "/airports/form";
    }

    @PostMapping
    public String saveFlight(@ModelAttribute("airport") Airport airport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airports/form";
        }

        repo.save(airport);

        return "redirect:/airport";
    }

    /**
     * Demo showing 1) passing ID rather than Code 2) Handling of Optional when
     * using findById
     *
     * @param id
     * @return
     */
    @GetMapping(params = "delete")
    public String delete(@RequestParam Long id) {
        Airport airport = repo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid airport id:" + id)
        );
        repo.delete(airport);
        return "redirect:/airport";
    }

}
