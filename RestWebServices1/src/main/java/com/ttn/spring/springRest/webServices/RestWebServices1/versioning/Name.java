package com.ttn.spring.springRest.webServices.RestWebServices1.versioning;

public class Name {
    private String firstName;
    private String lastName;

    public Name() {
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
