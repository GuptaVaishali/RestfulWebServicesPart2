package com.ttn.spring.springRest.webServices.RestWebServices1.springWelcome;

import com.ttn.spring.springRest.webServices.RestWebServices1.springWelcome.WelcomeToSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeToSpringController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/welcome-spring")
    public String SpringWorld(){
        return "Welcome to spring boot";
    }

    @GetMapping("/welcome-spring-bean")
    public WelcomeToSpring springBootWorld(){
        return new WelcomeToSpring("Welcome to spring boot");
    }

    @GetMapping(path = "/hello-employee-itn")
    public String helloWorldInternationalized(@RequestParam String username){
        return messageSource.getMessage("good.morning.message",null,
                LocaleContextHolder.getLocale()) + " " + username;
    }

}
