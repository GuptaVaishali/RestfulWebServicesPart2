package com.ttn.spring.springRest.webServices.RestWebServices1.versioning;

public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

}
