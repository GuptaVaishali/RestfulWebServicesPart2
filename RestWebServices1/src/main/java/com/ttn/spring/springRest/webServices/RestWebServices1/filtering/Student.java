package com.ttn.spring.springRest.webServices.RestWebServices1.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

//use for dynamic filter
@JsonFilter("StudentFilter")
public class Student {

    private String username;

    //use for static filter
   // @JsonIgnore
    private String password;
    private Integer age;

    public Student() {
    }

    public Student(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
