package com.ttn.spring.springRest.webServices.RestWebServices1.employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel(description = "Employee Details")
public class EmployeeBean {

    @ApiModelProperty(notes = "id should be unique")
    private Integer id;


    @ApiModelProperty(notes = "names should be of string type")
    @Pattern(regexp = "[a-zA-Z]*", message = "Name should contain alphabets only")
    @Size(min = 2, message = "Name length should be greater than 2")
    private String name;

    @ApiModelProperty(notes = "Age should be between 18 and 60")
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
