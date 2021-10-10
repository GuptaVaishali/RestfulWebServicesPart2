package com.ttn.spring.springRest.webServices.RestWebServices1.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDaoService service;

    @GetMapping("/employees")
    public List<EmployeeBean> retrieveAllEmployees() {
        return service.findAll();
    }

    @GetMapping("/employees/{id}")
    public EmployeeBean retrieveEmployee(@PathVariable int id){
        EmployeeBean employee = service.findOne(id);
        if(employee == null)
            throw new EmployeeNotFoundException("id- " + id);
        return employee;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createUser(@RequestBody EmployeeBean employee){
        EmployeeBean savedEmployee = service.save(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public void DeleteUser(@PathVariable int id){
        EmployeeBean employee = service.deleteById(id);
        if(employee == null)
            throw new EmployeeNotFoundException("id-" + id);
    }


}
