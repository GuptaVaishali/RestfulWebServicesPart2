package com.ttn.spring.springRest.webServices.RestWebServices1.versioning;

public class PersonV1 {
    private String name;

    PersonV1(){
    }

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
