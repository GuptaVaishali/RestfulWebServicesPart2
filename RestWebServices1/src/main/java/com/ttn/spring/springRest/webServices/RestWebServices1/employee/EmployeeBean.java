package com.ttn.spring.springRest.webServices.RestWebServices1.employee;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeBean {
    private Integer id;

    @Pattern(regexp = "[a-zA-Z]*", message = "Name should contain alphabets only")
    @Size(min = 2, message = "Name length should be greater than 2")
    private String name;

    @Min(value = 18, message = "Minimum age of employee should be 18")
    @Max(value = 60, message = "Maximum age of employee should be 60")
    private Integer age;

    public EmployeeBean(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
