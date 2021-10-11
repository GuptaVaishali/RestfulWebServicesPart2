package com.ttn.spring.springRest.webServices.RestWebServices1.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    //Content Negotiation or Accept versioning or MIME type versioning or producer versioning

    @GetMapping(value = "person/produces",produces = "application/v1+json")
    public PersonV1 personAcceptV1(){
        return new PersonV1("Vaishali");
    }

    @GetMapping(value = "person/produces",produces = "application/v2+json")
    public PersonV2 personAcceptV2(){
        return new PersonV2(new Name("Vaishali","Gupta"));
    }


    //header versioning
    @GetMapping(value = "person/header",headers = "VERSION=1")
    public PersonV1 personHeaderV1(){
        return new PersonV1("Vaishali");
    }

    @GetMapping(value = "person/header",headers = "VERSION=2")
    public PersonV2 personHeaderV2(){
        return new PersonV2(new Name("Vaishali","Gupta"));
    }


    //url versioning
   @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Vaishali");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Vaishali","Gupta"));
    }



    //Param versioning
    @GetMapping(value = "person/param",params = "version=1")
    public PersonV1 personParamV1(){
        return new PersonV1("Vaishali");
    }

    @GetMapping(value = "person/param",params = "version=2")
    public PersonV2 personParamV2(){
        return new PersonV2(new Name("Vaishali","Gupta"));
    }

}
