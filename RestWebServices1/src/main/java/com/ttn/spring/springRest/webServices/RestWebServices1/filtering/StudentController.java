package com.ttn.spring.springRest.webServices.RestWebServices1.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    /***** Static Filtering *********/
    @GetMapping("/student-static-filter")
    public Student findStudent(){
        return new Student("Vaishali","vaishali123",24);
    }

    /****** Dynamic Filtering  ******/
    @GetMapping("/student-dynamic-filter")
    public MappingJacksonValue retrieveSomeBean(){
        Student student = new Student("Nidhi","Nidhi123",30);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("username","age");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("StudentFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(student);
        mapping.setFilters(filters);
        return mapping;
    }

}
