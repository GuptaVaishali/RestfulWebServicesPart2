package com.ttn.spring.springRest.webServices.RestWebServices1.springWelcome;

import com.ttn.spring.springRest.webServices.RestWebServices1.springWelcome.WelcomeToSpring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeToSpringController {

    @GetMapping("/welcome-spring")
    public String SpringWorld(){
        return "Welcome to spring boot";
    }

    @GetMapping("/welcome-spring-bean")
    public WelcomeToSpring springBootWorld(){
        return new WelcomeToSpring("Welcome to spring boot");
    }
}
