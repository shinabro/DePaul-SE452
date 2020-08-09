package edu.depaul.cdm.se452.concept.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @Value( "${app.greeting}" )
    private String greeting;

    @GetMapping("/")
    public ModelAndView showGreeting() {
        ModelAndView mv = new ModelAndView("greeting");
        mv.addObject("name", greeting);
        return mv;
    }

}